package view;

import javax.swing.*;
import java.awt.*;

public class MedicalRecordsGUI extends BaseFormGUI {
	private static final long serialVersionUID = 1L;

	private JTextField txtPetName;
	private JTextField txtOwnerName;
	private JTextField txtVetName;
	private JComboBox<String> cmbRecordType;
	private JTextField txtDate;
	private JTextField txtDiagnosis;
	private JTextField txtTreatment;
	private JTextField txtMedication;
	private JTextArea txtNotes;

	/**
	 * Create the panel.
	 */
	public MedicalRecordsGUI() {
		super("Medical Record Details",
				new String[] {"ID", "Pet Name", "Owner", "Vet", "Record Type", "Date",
						"Diagnosis", "Treatment", "Medication", "Notes"});
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

		// Row 1: Vet Name / Record Type
		formPanel.add(new JLabel("Veterinarian:"), gbc(0, 1, 1, false));
		txtVetName = new JTextField(15);
		formPanel.add(txtVetName, gbc(1, 1, 1, true));

		formPanel.add(new JLabel("Record Type:"), gbc(2, 1, 1, false));
		cmbRecordType = new JComboBox<>(new String[] {
				"Checkup", "Vaccination", "Surgery", "Injury", "Illness", "Lab Result", "Dental"
		});
		formPanel.add(cmbRecordType, gbc(3, 1, 1, true));

		// Row 2: Date / Diagnosis
		formPanel.add(new JLabel("Date (yyyy-mm-dd):"), gbc(0, 2, 1, false));
		txtDate = new JTextField(15);
		formPanel.add(txtDate, gbc(1, 2, 1, true));

		formPanel.add(new JLabel("Diagnosis:"), gbc(2, 2, 1, false));
		txtDiagnosis = new JTextField(15);
		formPanel.add(txtDiagnosis, gbc(3, 2, 1, true));

		// Row 3: Treatment / Medication
		formPanel.add(new JLabel("Treatment:"), gbc(0, 3, 1, false));
		txtTreatment = new JTextField(15);
		formPanel.add(txtTreatment, gbc(1, 3, 1, true));

		formPanel.add(new JLabel("Medication:"), gbc(2, 3, 1, false));
		txtMedication = new JTextField(15);
		formPanel.add(txtMedication, gbc(3, 3, 1, true));

		// Row 4: Notes
		formPanel.add(new JLabel("Notes:"), gbc(0, 4, 1, false));
		txtNotes = new JTextArea(3, 20);
		txtNotes.setLineWrap(true);
		txtNotes.setWrapStyleWord(true);
		JScrollPane notesScroll = new JScrollPane(txtNotes);
		formPanel.add(notesScroll, gbc(1, 4, 3, true));

		return 5; // next free row, where BaseFormGUI places the button row
	}

	// Getters specific to this panel's fields
	public JTextField getTxtPetName() { return txtPetName; }
	public JTextField getTxtOwnerName() { return txtOwnerName; }
	public JTextField getTxtVetName() { return txtVetName; }
	public JComboBox<String> getCmbRecordType() { return cmbRecordType; }
	public JTextField getTxtDate() { return txtDate; }
	public JTextField getTxtDiagnosis() { return txtDiagnosis; }
	public JTextField getTxtTreatment() { return txtTreatment; }
	public JTextField getTxtMedication() { return txtMedication; }
	public JTextArea getTxtNotes() { return txtNotes; }
}
