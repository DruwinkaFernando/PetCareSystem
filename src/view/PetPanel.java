
package view;

import dao.OwnerDAO;
import dao.PetDAO;
import model.Owner;
import model.Pet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt;
import java.util.List;

public class PetPanel extends JPanel
{
	private final PetDAO petDAO = new PetDAO();
	private final OwnerDAO petDAO = new PetDAO();
	private DafaultTableModel model;
	private JTable table;

	public Petpanel()
	{
		setlayout(new BorderLayout(10, 10));
		setBackground(UIStyle.LIGHT_BG);
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JPanel top = new JPanel (new BorderLayout());
		top.setOpaque(false);
		JLabel title = new JLabel("Pet Management");
		title.setFont(UIStyle.FONT_TITLE);
		top.add(title, BorderLayout.WEST);

		RoundButton addBtn = new RoundButoon("+ Add New Pet", UIStyle.PINK_ACCENT, Color.WHITE);
		addBtn.setPreferredSize(new Dimension(160, 36));
		addBtn.addActionListener(e -> showForm(null));
		top.add(addBtn, BorderLayout.EAST);
		add(top, BorderLayout.NORTH);

		String[] cols = {"Pet ID", "Name", "Species", "Breed", "Age", "Gender", "Owner ID"};
		model = new DefaultTableModel(cols, 0){
			public boolean isCellEditable(int r, int C){ return false; }
		};
		table = new JTable(Model);
		table.setRowHeight(28);
		add(new JScrollPane(table), BorderLayout.CENTER);

		JPanel bottom = new JPanel(new FlowLayout (FlowLayout.RIGHT));
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

	private void refreshTable(){
		model.setRowCount(0);
		for (Pet p : petDao.getAll()){
			model.addRow(new Object[]{p.getPetId(), p.getName(), p.getSpecies(), p.getBreed(), p.getAge(), p.getGender(), p.getOwnerId()});
		}
	}

	private void editSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select a pet first."); return; }
        String id = (String) model.getValueAt(row, 0);
        Pet found = null;
        for (Pet p : petDAO.getAll()) if (p.getPetId().equals(id)) found = p;
        showForm(found);
	}

	private void deleteSelected() {
        int row = table.getSelectedRow();
        if (row < 0) { JOptionPane.showMessageDialog(this, "Select a pet first."); return; }
        String id = (String) model.getValueAt(row, 0);
        int c = JOptionPane.showConfirmDialog(this, "Delete pet " + id + "?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (c == JOptionPane.YES_OPTION) { petDAO.delete(id); refreshTable(); }
    }

	private void showForm(Pet existing) {
        JTextField name = new JTextField(existing != null ? existing.getName() : "");
        JTextField species = new JTextField(existing != null ? existing.getSpecies() : "");
        JTextField breed = new JTextField(existing != null ? existing.getBreed() : "");
        JTextField age = new JTextField(existing != null ? String.valueOf(existing.getAge()) : "");
        JComboBox<String> gender = new JComboBox<>(new String[]{"Male", "Female"});
        if (existing != null) gender.setSelectedItem(existing.getGender());

        List<Owner> owners = ownerDAO.getAll();
        JComboBox<String> ownerBox = new JComboBox<>();
        for (Owner o : owners) ownerBox.addItem(o.getOwnerId() + " - " + o.getName());
        if (existing != null) {
            for (int i = 0; i < owners.size(); i++)
                if (owners.get(i).getOwnerId().equals(existing.getOwnerId())) ownerBox.setSelectedIndex(i);
        }

		JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.add(new JLabel("Name:")); panel.add(name);
        panel.add(new JLabel("Species:")); panel.add(species);
        panel.add(new JLabel("Breed:")); panel.add(breed);
        panel.add(new JLabel("Age:")); panel.add(age);
        panel.add(new JLabel("Gender:")); panel.add(gender);
        panel.add(new JLabel("Owner:")); panel.add(ownerBox);

        if (owners.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please add an Owner first (Owners module).");
            return;
        }

        int result = JOptionPane.showConfirmDialog(this, panel, existing == null ? "Add New Pet" : "Edit Pet",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int ageVal = Integer.parseInt(age.getText().trim());
                String ownerId = owners.get(ownerBox.getSelectedIndex()).getOwnerId();
                if (existing == null) {
                    Pet p = new Pet(petDAO.generateId(), name.getText(), species.getText(), breed.getText(), ageVal, (String) gender.getSelectedItem(), ownerId);
                    petDAO.add(p);
                } else {
                    existing.setName(name.getText());
                    existing.setSpecies(species.getText());
                    existing.setBreed(breed.getText());
                    existing.setAge(ageVal);
                    existing.setGender((String) gender.getSelectedItem());
                    existing.setOwnerId(ownerId);
                    petDAO.update(existing);
                }
                refreshTable();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age must be a number.");
            }
        }
    }
}

	
