package view;

import javax.swing.*;
import java.awt.*;
import model.Pet;

public class PetsGUI extends BaseFormGUI
{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtPetID;
	private JTextField txtName;
	private JComboBox<String> cmbSpecies;
	private JTextField txtBreed;
	private JTextField txtAge;
	private JComboBox<String> cmbGender;
	private JTextField txtColor;
	private JTextField txtHealthStatus;
	private JComboBox<String> cmbVaccinationStatus;
	private JTextArea txtNotes;
	
	/**
		* Create the panel.
	*/
	public PetsGUI() 
	{
		super("Pet Management", "Add, update, or manage pet information", new String[]
				{
					"Pet ID", "Name", "Species", "Breed", "Age", "Gender", "Color", "Health Status", "Vaccination", "Notes"
				});
		getBtnAdd().addActionListener(e -> addPet());
	}


	@Override
	protected int addFields(JPanel formPanel)
	{
		//Row 0: Pet ID / Name
		formPanel.add(new JLabel("Pet ID:"), gbc(0, 0, 1, false));
		txtPetID = new JTextField(10);
		formPanel.add(txtPetID, gbc(1, 0, 1, true));

		formPanel.add(new JLabel("Name:"), gbc(2, 0, 1, false));
		txtName = new JTextField(15);
		formPanel.add(txtName, gbc(3, 0, 1, true));

		//Row 1: Species / Breed
		formPanel.add(new JLabel("Species:"), gbc(0, 1, 1, false));
		cmbSpecies = new JComboBox<>(new String[]
		{
			"Dog", "Cat", "Bird", "Rabbit"
		});
		formPanel.add(cmbSpecies, gbc(1, 1, 1, true));

		formPanel.add(new JLabel("Breed:"), gbc(2, 1, 1, false));
		txtBreed = new JTextField(15);
		formPanel.add(txtBreed, gbc(3, 1, 1, true));

		// Row 2: Age / Gender
		formPanel.add(new JLabel("Age:"), gbc(0, 2, 1, false));
		txtAge = new JTextField(10);
		formPanel.add(txtAge, gbc(1, 2, 1, true));

		formPanel.add(new JLabel("Gender:"), gbc(2, 2, 1, false));
		cmbGender = new JComboBox<>(new String[]
		{
			"Male", "Female"
		});
		formPanel.add(cmbGender, gbc(3, 2, 1, true));

		//Row 3: Color / Health Status
		formPanel.add(new JLabel("Color:"), gbc(0, 3, 1, false));
		txtColor = new JTextField(15);
		formPanel.add(txtColor, gbc(1, 3, 1, true));

		formPanel.add(new JLabel("Health Status:"), gbc(2, 3, 1, false));
		txtHealthStatus = new JTextField(15);
		formPanel.add(txtHealthStatus, gbc(3, 3, 1, true));

		//Row 4: Vaccination / Notes
		formPanel.add(new JLabel("Vaccination:"), gbc(0, 4, 1, false));
		cmbVaccinationStatus = new JComboBox<>(new String[]
		{
			"Up to date", "due", "Overdue"
		});
		formPanel.add(cmbVaccinationStatus, gbc(1, 4, 1, true));

		formPanel.add(new JLabel("Notes:"), gbc(2, 4, 1, false));
		txtNotes = new JTextArea(3, 15);
		txtNotes.setLineWrap(true);
		txtNotes.setWrapStyleWord(true);

		JScrollPane notesScroll = new JScrollPane(txtNotes);
		formPanel.add(notesScroll, gbc(3, 4, 1, true));


		return 5;
	}
 
	private void addPet() 
	{
		try 
		{
	        int petID = Integer.parseInt(txtPetID.getText().trim());
	        String name = txtName.getText().trim();
	        String species = (String) cmbSpecies.getSelectedItem();
	        String breed = txtBreed.getText().trim();
	        int age = Integer.parseInt(txtAge.getText().trim());
	        String gender = (String) cmbGender.getSelectedItem();
	        String color = txtColor.getText().trim();
	        String healthStatus = txtHealthStatus.getText().trim();
	        String vaccinationStatus = (String) cmbVaccinationStatus.getSelectedItem();
	        String notes = txtNotes.getText().trim();
	
	        Pet pet = new Pet(
	                petID,
	                name,
	                species,
	                breed,
	                age,
	                gender,
	                color,
	                healthStatus,
	                vaccinationStatus,
	                notes
	        );
	
	        getTableModel().addRow(new Object[] {
	                pet.getPetID(),
	                pet.getName(),
	                pet.getSpecies(),
	                pet.getBreed(),
	                pet.getAge(),
	                pet.getGender(),
	                pet.getColor(),
	                pet.getHealthStatus(),
	                pet.getVaccinationStatus(),
	                pet.getNotes()
        });

        JOptionPane.showMessageDialog(this, "Pet added successfully!");

   	 	} 
		catch (NumberFormatException ex) 
		{
			JOptionPane.showMessageDialog(this, "Pet ID and Age must be numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    	}
	}

	// Getters
	public JTextField getTxtPetID()
	{
		return txtPetID;
	}

	public JTextField getTxtName()
	{
		return txtName;
	}

	public JComboBox<String> getcmbSpecies()
	{
		return cmbSpecies;
	}

	public JTextField getTxtBreed()
	{
		return txtBreed;
	}

	public JTextField getTxtAge()
	{
		return txtAge;
	}

	public JComboBox<String> getcmbGender()
	{
		return cmbGender;
	}

	public JTextField getTxtColor()
	{
		return txtColor;
	}

	public JTextField getTxtHealthStatus()
	{
		return txtHealthStatus;
	}

	public JComboBox<String> getcmbVaccinationStatus()
	{
		return cmbVaccinationStatus;
	}

	public JTextArea getTxtNotes()
	{
		return txtNotes;
	}	   
}
