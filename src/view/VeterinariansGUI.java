package view;

import javax.swing.*;
import java.awt.*;

public class VeterinariansGUI extends BaseFormGUI {
	private static final long serialVersionUID = 1L;

	private JTextField txtName;
	private JComboBox<String> cmbSpecialization;
	private JTextField txtContact;
	private JTextField txtEmail;
	private JTextField txtLicenseNo;
	private JComboBox<String> cmbStatus;

	/**
	 * Create the panel.
	 */
	public VeterinariansGUI() {
		super("Veterinarian Details",
				new String[] {"ID", "Name", "Specialization", "Contact No", "Email", "License No", "Status"});
	}

	@Override
	protected int addFields(JPanel formPanel) {
		// Row 0: Name / Specialization
		formPanel.add(new JLabel("Name:"), gbc(0, 0, 1, false));
		txtName = new JTextField(15);
		formPanel.add(txtName, gbc(1, 0, 1, true));

		formPanel.add(new JLabel("Specialization:"), gbc(2, 0, 1, false));
		cmbSpecialization = new JComboBox<>(new String[] {
				"General Practice", "Surgery", "Dermatology", "Dentistry",
				"Cardiology", "Orthopedics", "Exotic Animals"
		});
		formPanel.add(cmbSpecialization, gbc(3, 0, 1, true));

		// Row 1: Contact / Email
		formPanel.add(new JLabel("Contact No:"), gbc(0, 1, 1, false));
		txtContact = new JTextField(15);
		formPanel.add(txtContact, gbc(1, 1, 1, true));

		formPanel.add(new JLabel("Email:"), gbc(2, 1, 1, false));
		txtEmail = new JTextField(15);
		formPanel.add(txtEmail, gbc(3, 1, 1, true));

		// Row 2: License No / Status
		formPanel.add(new JLabel("License No:"), gbc(0, 2, 1, false));
		txtLicenseNo = new JTextField(15);
		formPanel.add(txtLicenseNo, gbc(1, 2, 1, true));

		formPanel.add(new JLabel("Status:"), gbc(2, 2, 1, false));
		cmbStatus = new JComboBox<>(new String[] { "Available", "On Leave", "Off Duty" });
		formPanel.add(cmbStatus, gbc(3, 2, 1, true));

		return 3; // next free row, where BaseFormGUI places the button row
	}

	// Getters specific to this panel's fields
	public JTextField getTxtName() { return txtName; }
	public JComboBox<String> getCmbSpecialization() { return cmbSpecialization; }
	public JTextField getTxtContact() { return txtContact; }
	public JTextField getTxtEmail() { return txtEmail; }
	public JTextField getTxtLicenseNo() { return txtLicenseNo; }
	public JComboBox<String> getCmbStatus() { return cmbStatus; }
}
