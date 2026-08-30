package view;

import dao.AppointmentDAO;
import dao.PetDAO;
import model.Appointment;
import model.Pet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

@SuppressWarnings("serial")
public class AppointmentPanel extends JPanel {
    private final AppointmentDAO apptDAO = new AppointmentDAO();
    private final PetDAO petDAO = new PetDAO();
    private DefaultTableModel model;
    private JTable table;

    public AppointmentPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(UIStyle.LIGHT_BG);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        JLabel title = new JLabel("Appointment Management");
        title.setFont(UIStyle.FONT_TITLE);
        top.add(title, BorderLayout.WEST);

        RoundedButton addBtn = new RoundedButton("+ New Appointment", UIStyle.PINK_ACCENT, Color.WHITE);
        addBtn.setPreferredSize(new Dimension(180, 36));
        addBtn.addActionListener(e -> showForm(null));
        top.add(addBtn, BorderLayout.EAST);
        add(top, BorderLayout.NORTH);

        String[] cols = {"Appt ID", "Date", "Time", "Pet ID", "Service", "Status"};
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
        for (Appointment a : apptDAO.getAll()) {
            model.addRow(new Object[]{a.getPetId(), a.getDate(), a.getTime(), a.getPetId(), a.getService(), a.getStatus()});
        }
    }

    private void editSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select an appointment first."); return; }
        String id = (String) model.getValueAt(row, 0);
        Appointment found = null;
        for (Appointment a : apptDAO.getAll()) if (a.getPetId().equals(id)) found = a;
        showForm(found);
    }

    private void deleteSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select an appointment first."); return; }
        String id = (String) model.getValueAt(row, 0);
        int c = JOptionPane.showConfirmDialog(this, "Delete appointment " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) { apptDAO.delete(id); refreshTable(); }
    }

    private void showForm(Appointment existing) {
        List<Pet> pets = petDAO.getAll();
        if (pets.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add a Pet first (Pets module).");
            return;
        }
        JTextField date = new JTextField(existing != null ? existing.getDate() : "DD-MM-YYYY");
        JTextField time = new JTextField(existing != null ? existing.getTime() : "HH:MM AM/PM");
        JComboBox<String> petBox = new JComboBox<>();
        for (Pet p : pets) petBox.addItem(p.getPetId() + " - " + p.getName());
        if (existing != null) {
            for (int i = 0; i < pets.size(); i++) if (pets.get(i).getPetId().equals(existing.getPetId())) petBox.setSelectedIndex(i);
        }
        JComboBox<String> service = new JComboBox<>(new String[]{"Vaccination", "Health Check", "Grooming", "Consultation", "Deworming", "Surgery"});
        if (existing != null) service.setSelectedItem(existing.getService());
        JComboBox<String> status = new JComboBox<>(new String[]{"Pending", "Confirmed", "Completed", "Cancelled"});
        if (existing != null) status.setSelectedItem(existing.getStatus());

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.add(new JLabel("Date:")); panel.add(date);
        panel.add(new JLabel("Time:")); panel.add(time);
        panel.add(new JLabel("Pet:")); panel.add(petBox);
        panel.add(new JLabel("Service:")); panel.add(service);
        panel.add(new JLabel("Status:")); panel.add(status);

        int result = JOptionPane.showConfirmDialog(this, panel, existing == null ? "New Appointment" : "Edit Appointment",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String petId = pets.get(petBox.getSelectedIndex()).getPetId();
            if (existing == null) {
                Appointment a = new Appointment(apptDAO.generateId(), date.getText(), time.getText(), petId,
                        (String) service.getSelectedItem(), (String) status.getSelectedItem());
                apptDAO.add(a);
            } else {
                existing.setDate(date.getText());
                existing.setTime(time.getText());
                existing.setPetId(petId);
                existing.setService((String) service.getSelectedItem());
                existing.setStatus((String) status.getSelectedItem());
                apptDAO.update(existing);
            }
            refreshTable();
        }
    }
}
