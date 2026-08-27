package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AppointmentGUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField txtPatientName;
	private JTextField txtDoctor;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextArea txtNotes;

	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnClear;

	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public AppointmentGUI() {
		setLayout(new BorderLayout(10, 10));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		add(buildFormPanel(), BorderLayout.NORTH);
		add(buildTablePanel(), BorderLayout.CENTER);
	}

	private JPanel buildFormPanel() {
		JPanel formPanel = new JPanel(new GridBagLayout());
		formPanel.setBorder(BorderFactory.createTitledBorder("Appointment Details"));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Row 0
		gbc.gridx = 0; gbc.gridy = 0;
		formPanel.add(new JLabel("Patient Name:"), gbc);
		gbc.gridx = 1;
		txtPatientName = new JTextField(15);
		formPanel.add(txtPatientName, gbc);

		gbc.gridx = 2;
		formPanel.add(new JLabel("Doctor:"), gbc);
		gbc.gridx = 3;
		txtDoctor = new JTextField(15);
		formPanel.add(txtDoctor, gbc);

		// Row 1
		gbc.gridx = 0; gbc.gridy = 1;
		formPanel.add(new JLabel("Date (yyyy-mm-dd):"), gbc);
		gbc.gridx = 1;
		txtDate = new JTextField(15);
		formPanel.add(txtDate, gbc);

		gbc.gridx = 2;
		formPanel.add(new JLabel("Time (HH:mm):"), gbc);
		gbc.gridx = 3;
		txtTime = new JTextField(15);
		formPanel.add(txtTime, gbc);

		// Row 2 - Notes
		gbc.gridx = 0; gbc.gridy = 2;
		formPanel.add(new JLabel("Notes:"), gbc);
		gbc.gridx = 1; gbc.gridwidth = 3;
		txtNotes = new JTextArea(3, 20);
		txtNotes.setLineWrap(true);
		JScrollPane notesScroll = new JScrollPane(txtNotes);
		formPanel.add(notesScroll, gbc);
		gbc.gridwidth = 1;

		// Row 3 - Buttons
		gbc.gridx = 0; gbc.gridy = 3;
		btnAdd = new JButton("Add");
		formPanel.add(btnAdd, gbc);

		gbc.gridx = 1;
		btnUpdate = new JButton("Update");
		formPanel.add(btnUpdate, gbc);

		gbc.gridx = 2;
		btnDelete = new JButton("Delete");
		formPanel.add(btnDelete, gbc);

		gbc.gridx = 3;
		btnClear = new JButton("Clear");
		formPanel.add(btnClear, gbc);

		return formPanel;
	}

	private JScrollPane buildTablePanel() {
		String[] columns = {"ID", "Patient Name", "Doctor", "Date", "Time", "Notes"};
		tableModel = new DefaultTableModel(columns, 0) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // table is read-only; edits happen via the form
			}
		};
		table = new JTable(tableModel);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		return new JScrollPane(table);
	}

	// Getters so a controller class can wire up listeners and read field values
	public JTextField getTxtPatientName() { return txtPatientName; }
	public JTextField getTxtDoctor() { return txtDoctor; }
	public JTextField getTxtDate() { return txtDate; }
	public JTextField getTxtTime() { return txtTime; }
	public JTextArea getTxtNotes() { return txtNotes; }
	public JButton getBtnAdd() { return btnAdd; }
	public JButton getBtnUpdate() { return btnUpdate; }
	public JButton getBtnDelete() { return btnDelete; }
	public JButton getBtnClear() { return btnClear; }
	public JTable getTable() { return table; }
	public DefaultTableModel getTableModel() { return tableModel; }
}
