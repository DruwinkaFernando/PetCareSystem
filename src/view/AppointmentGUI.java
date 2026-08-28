package view;

import javax.swing.*;
import java.awt.*;

public class AppointmentGUI extends BaseFormGUI {
	private static final long serialVersionUID = 1L;

	private JTextField txtPetName;
	private JTextField txtOwnerName;
	private JComboBox<String> cmbServiceType;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtStaff;
	private JTextArea txtNotes;

	/**
	 * Create the panel.
	 */
	public AppointmentGUI() {
		super("Appointment details", "Book, update, or cancel appointments",
				new String[] {"ID", "Pet Name", "Owner", "Service", "Date", "Time", "Staff", "Notes"});
	}

	@Override
	protected int addFields(JPanel formPanel) {
		// Row 0: Pet Name / Owner Name
		formPanel.add(new JLabel("Pet Name:"), gbc(0, 0, 1, false));
		txtPetName = new JTextField(15);
		formPanel.add(txtPetName, gbc(1, 0, 1, true));

		formPanel.add(new JLabel("Owner Name:"), gbc(2, 0, 1, false));
		txtOwnerName = new JTextField(15);
		formPanel.add(txtOwnerName, gbc(3, 0, 1, true));

		// Row 1: Service Type / Assigned Staff
		formPanel.add(new JLabel("Service Type:"), gbc(0, 1, 1, false));
		cmbServiceType = new JComboBox<>(new String[] {
				"Vet Checkup", "Vaccination", "Grooming", "Surgery", "Dental Care", "Boarding"
		});
		formPanel.add(cmbServiceType, gbc(1, 1, 1, true));

		formPanel.add(new JLabel("Assigned Staff:"), gbc(2, 1, 1, false));
		txtStaff = new JTextField(15);
		formPanel.add(txtStaff, gbc(3, 1, 1, true));

		// Row 2: Date / Time
		formPanel.add(new JLabel("Date (yyyy-mm-dd):"), gbc(0, 2, 1, false));
		txtDate = new JTextField(15);
		formPanel.add(txtDate, gbc(1, 2, 1, true));

		formPanel.add(new JLabel("Time (HH:mm):"), gbc(2, 2, 1, false));
		txtTime = new JTextField(15);
		formPanel.add(txtTime, gbc(3, 2, 1, true));

		// Row 3: Notes
		formPanel.add(new JLabel("Notes:"), gbc(0, 3, 1, false));
		txtNotes = new JTextArea(3, 20);
		txtNotes.setLineWrap(true);
		txtNotes.setWrapStyleWord(true);
		JScrollPane notesScroll = new JScrollPane(txtNotes);
		formPanel.add(notesScroll, gbc(1, 3, 3, true));

		return 4; // next free row, where BaseFormGUI places the button row
	}

	// Getters specific to this panel's fields
	public JTextField getTxtPetName() { return txtPetName; }
	public JTextField getTxtOwnerName() { return txtOwnerName; }
	public JComboBox<String> getCmbServiceType() { return cmbServiceType; }
	public JTextField getTxtDate() { return txtDate; }
	public JTextField getTxtTime() { return txtTime; }
	public JTextField getTxtStaff() { return txtStaff; }
	public JTextArea getTxtNotes() { return txtNotes; }
}
