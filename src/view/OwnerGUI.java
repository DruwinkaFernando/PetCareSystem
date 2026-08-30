package view;

import javax.swing.*;
import java.awt.*;

public class OwnerGUI extends BaseFormGUI {
	private static final long serialVersionUID = 1L;

	private JTextField txtOwnerName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JTextField txtPetName;
	private JTextField txtRegisteredDate;

	/**
	 * Create the panel.
	 */
	public OwnerGUI() {
		super("Owners", "Add, update, or view pet owner details",
				new String[] {"ID", "Owner Name", "Phone", "Email", "Address", "Pet Name", "Registered Date"});
	}

	@Override
	protected int addFields(JPanel formPanel) {
		// Row 0: Owner Name / Phone
		formPanel.add(new JLabel("Owner Name:"), gbc(0, 0, 1, false));
		txtOwnerName = new JTextField(15);
		formPanel.add(txtOwnerName, gbc(1, 0, 1, true));

		formPanel.add(new JLabel("Phone:"), gbc(2, 0, 1, false));
		txtPhone = new JTextField(15);
		formPanel.add(txtPhone, gbc(3, 0, 1, true));

		// Row 1: Email / Address
		formPanel.add(new JLabel("Email:"), gbc(0, 1, 1, false));
		txtEmail = new JTextField(15);
		formPanel.add(txtEmail, gbc(1, 1, 1, true));

		formPanel.add(new JLabel("Address:"), gbc(2, 1, 1, false));
		txtAddress = new JTextField(15);
		formPanel.add(txtAddress, gbc(3, 1, 1, true));

		// Row 2: Pet Name / Registered Date
		formPanel.add(new JLabel("Pet Name:"), gbc(0, 2, 1, false));
		txtPetName = new JTextField(15);
		formPanel.add(txtPetName, gbc(1, 2, 1, true));

		formPanel.add(new JLabel("Registered Date:"), gbc(2, 2, 1, false));
		txtRegisteredDate = new JTextField(15);
		formPanel.add(txtRegisteredDate, gbc(3, 2, 1, true));

		return 3; // next free row, where BaseFormGUI places the button row
	}

	// Getters specific to this panel's fields
	public JTextField getTxtOwnerName() { return txtOwnerName; }
	public JTextField getTxtPhone() { return txtPhone; }
	public JTextField getTxtEmail() { return txtEmail; }
	public JTextField getTxtAddress() { return txtAddress; }
	public JTextField getTxtPetName() { return txtPetName; }
	public JTextField getTxtRegisteredDate() { return txtRegisteredDate; }
}
