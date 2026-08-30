package view;

import dao.BillingDAO;
import dao.PetDAO;
import model.Billing;
import model.Pet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BillingPanel extends JPanel {
    private final BillingDAO billingDAO = new BillingDAO();
    private final PetDAO petDAO = new PetDAO();
    private DefaultTableModel model;
    private JTable table;

    public BillingPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(UIStyle.LIGHT_BG);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        JLabel title = new JLabel("Billing & Invoices");
        title.setFont(UIStyle.FONT_TITLE);
        top.add(title, BorderLayout.WEST);

        RoundedButton addBtn = new RoundedButton("+ New Invoice", UIStyle.PINK_ACCENT, Color.WHITE);
        addBtn.setPreferredSize(new Dimension(150, 36));
        addBtn.addActionListener(e -> showForm(null));
        top.add(addBtn, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        String[] cols = {"Invoice No", "Date", "Pet ID", "Service", "Amount (LKR)", "Status"};
        model = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };
        table = new JTable(model);
        table.setRowHeight(28);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setOpaque(false);
        JButton editBtn = new JButton("Edit Selected");
        JButton delBtn = new JButton("Delete Selected");
        editBtn.addActionListener(e -> editSelected());
        delBtn.addActionListener(e -> deleteSelected());
        bottom.add(editBtn);
        bottom.add(delBtn);
        add(bottom, BorderLayout.SOUTH);

        refreshTable();
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Billing b : billingDAO.getAll()) {
            model.addRow(new Object[]{b.getInvoiceNo(), b.getDate(), b.getPetId(), b.getService(), b.getAmount(), b.getStatus()});
        }
    }

    private void editSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select an invoice first."); return; }
        String id = (String) model.getValueAt(row, 0);
        Billing found = null;
        for (Billing b : billingDAO.getAll()) if (b.getInvoiceNo().equals(id)) found = b;
        showForm(found);
    }

    private void deleteSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select an invoice first."); return; }
        String id = (String) model.getValueAt(row, 0);
        int c = JOptionPane.showConfirmDialog(this, "Delete invoice " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) { billingDAO.delete(id); refreshTable(); }
    }

    private void showForm(Billing existing) {
        List<Pet> pets = petDAO.getAll();
        if (pets.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add a Pet first (Pets module).");
            return;
        }
        JTextField date = new JTextField(existing != null ? existing.getDate() : "DD-MM-YYYY");
        JComboBox<String> petBox = new JComboBox<>();
        for (Pet p : pets) petBox.addItem(p.getPetId() + " - " + p.getName());
        if (existing != null) {
            for (int i = 0; i < pets.size(); i++) if (pets.get(i).getPetId().equals(existing.getPetId())) petBox.setSelectedIndex(i);
        }
        JComboBox<String> service = new JComboBox<>(new String[]{"Vaccination", "Health Check", "Grooming", "Consultation", "Deworming", "Surgery"});
        if (existing != null) service.setSelectedItem(existing.getService());
        JTextField amount = new JTextField(existing != null ? String.valueOf(existing.getAmount()) : "");
        JComboBox<String> status = new JComboBox<>(new String[]{"Paid", "Unpaid"});
        if (existing != null) status.setSelectedItem(existing.getStatus());

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.add(new JLabel("Date:")); panel.add(date);
        panel.add(new JLabel("Pet:")); panel.add(petBox);
        panel.add(new JLabel("Service:")); panel.add(service);
        panel.add(new JLabel("Amount:")); panel.add(amount);
        panel.add(new JLabel("Status:")); panel.add(status);

        int result = JOptionPane.showConfirmDialog(this, panel, existing == null ? "New Invoice" : "Edit Invoice",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                double amt = Double.parseDouble(amount.getText().trim());
                String petId = pets.get(petBox.getSelectedIndex()).getPetId();
                if (existing == null) {
                    Billing b = new Billing(billingDAO.generateId(), date.getText(), petId,
                            (String) service.getSelectedItem(), amt, (String) status.getSelectedItem());
                    billingDAO.add(b);
                } else {
                    existing.setDate(date.getText());
                    existing.setPetId(petId);
                    existing.setService((String) service.getSelectedItem());
                    existing.setAmount(amt);
                    existing.setStatus((String) status.getSelectedItem());
                    billingDAO.update(existing);
                }
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Amount must be a number.");
            }
        }
    }
}
