package view;

import dao.OwnerDAO;
import model.Owner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@SuppressWarnings("serial")
public class OwnerPanel extends JPanel {
    private final OwnerDAO ownerDAO = new OwnerDAO();
    private DefaultTableModel model;
    private JTable table;

    public OwnerPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(UIStyle.LIGHT_BG);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        JLabel title = new JLabel("Owner Management");
        title.setFont(UIStyle.FONT_TITLE);
        top.add(title, BorderLayout.WEST);

        RoundedButton addBtn = new RoundedButton("+ Add New Owner", UIStyle.PINK_ACCENT, Color.WHITE);
        addBtn.setPreferredSize(new Dimension(170, 36));
        addBtn.addActionListener(e -> showForm(null));
        top.add(addBtn, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        String[] cols = {"Owner ID", "Name", "Phone", "Email", "Address"};
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
        for (Owner o : ownerDAO.getAll()) {
            model.addRow(new Object[]{o.getOwnerId(), o.getName(), o.getPhone(), o.getEmail(), o.getAddress()});
        }
    }

    private void editSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select an owner first."); return; }
        String id = (String) model.getValueAt(row, 0);
        Owner found = null;
        for (Owner o : ownerDAO.getAll()) if (o.getOwnerId().equals(id)) found = o;
        showForm(found);
    }

    private void deleteSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select an owner first."); return; }
        String id = (String) model.getValueAt(row, 0);
        int c = JOptionPane.showConfirmDialog(this, "Delete owner " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) { ownerDAO.delete(id); refreshTable(); }
    }

    private void showForm(Owner existing) {
        JTextField name = new JTextField(existing != null ? existing.getName() : "");
        JTextField phone = new JTextField(existing != null ? existing.getPhone() : "");
        JTextField email = new JTextField(existing != null ? existing.getEmail() : "");
        JTextField address = new JTextField(existing != null ? existing.getAddress() : "");

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.add(new JLabel("Name:")); panel.add(name);
        panel.add(new JLabel("Phone:")); panel.add(phone);
        panel.add(new JLabel("Email:")); panel.add(email);
        panel.add(new JLabel("Address:")); panel.add(address);

        int result = JOptionPane.showConfirmDialog(this, panel, existing == null ? "Add New Owner" : "Edit Owner",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            if (existing == null) {
                Owner o = new Owner(ownerDAO.generateId(), name.getText(), phone.getText(), email.getText(), address.getText());
                ownerDAO.add(o);
            } else {
                existing.setName(name.getText());
                existing.setPhone(phone.getText());
                existing.setEmail(email.getText());
                existing.setAddress(address.getText());
                ownerDAO.update(existing);
            }
            refreshTable();
        }
    }
}
