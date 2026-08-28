package view;

import javax.swing.*;
import java.awt;

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
	private JTextField txtNotes;
	
		/**
		 * Create the panel.
		 */
		public PetsGUI() 
		{
			super("Pet Management", "Add, update, or manage pet information", new String[]
				  {
					  "Pet ID", "Name", "Species", "Breed", "Age", "Gender", "Color", "Health Status", "Vaccination", "Notes"
				  });
		}


		@Override
		protected int addFields(JPanel formPanel)
		{
			//Row 0: Pet ID / Name
			formPanel.add(new JLabel("Pet ID:"), gbc(0, 0, 1, false));
			txtPetID new JTextField(10);
			formPanel.add(textPetID, gbc(1, 0, 1, true));

			formPanel.add(new JLabel("Name:"), gbc(2, 0, 1, false));
			txtName = new 
		}
			setPreferredSize(new Dimension(980, 550));
			setLayout(null);
			mainPanel = new JPanel();
			mainPanel.setBounds(0, 0, 980, 550);
			cardLayout = new CardLayout();
			mainPanel.setLayout(cardLayout);
			add(mainPanel);
			JPanel petMenu = new JPanel();
			petMenu.setLayout(null);
			
			JButton btnDog = new JButton("Dog");
			btnDog.setHorizontalAlignment(SwingConstants.LEFT);
			btnDog.setBounds(0, 0, 980, 98);
			btnDog.setBackground(new Color(140, 51, 51));
			btnDog.setFont(new Font("Century", Font.BOLD, 33));
			btnDog.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) 
				{
			        cardLayout.show(mainPanel, "Dog");
			    }
			});
			petMenu.add(btnDog);
			
			JButton btnCat = new JButton("Cat");
			btnCat.setHorizontalAlignment(SwingConstants.LEFT);
			btnCat.setBounds(0, 95, 980, 98);
			btnCat.setBackground(new Color(255, 128, 0));
			btnCat.setFont(new Font("Century", Font.BOLD, 33));
			btnCat.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) 
				{
			        cardLayout.show(mainPanel, "Cat");
			    }
			});
			petMenu.add(btnCat);
			
			JButton btnBird = new JButton("Bird");
			btnBird .setHorizontalAlignment(SwingConstants.LEFT);
			btnBird .setBounds(0, 193, 980, 98);
			btnBird .setBackground(new Color(128, 255, 128));
			btnBird .setFont(new Font("Century", Font.BOLD, 33));
			btnBird.addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) 
				{
			        cardLayout.show(mainPanel, "Bird");
			    }
			});
			petMenu.add(btnBird );

			JButton btnRabbit = new JButton("Rabbit");
			btnRabbit .setHorizontalAlignment(SwingConstants.LEFT);
			btnRabbit .setBounds(0, 291, 980, 98);
			btnRabbit .setBackground(new Color(255, 204, 204));
			btnRabbit .setFont(new Font("Century", Font.BOLD, 33));
			btnRabbit .addActionListener(new ActionListener() 
			{
			    public void actionPerformed(ActionEvent e) 
				{
			        cardLayout.show(mainPanel, "Rabbit");
			    }
			});
			petMenu.add(btnRabbit );
			
			mainPanel.add(petMenu, "PetMenu");
			cardLayout.show(mainPanel, "PetMenu");
			
	
			DogGUI dogPanel = new DogGUI();
			mainPanel.add(dogPanel, "Dog");

			CatGUI catPanel = new CatGUI();
			mainPanel.add(CatPanel, "Cat");
			
			BirdGUI birdPanel = new BirdGUI();
			mainPanel.add(birdPanel, "Bird");

			RabbitGUI rabbitPanel = new RabbitGUI();
			mainPanel.add(rabbitPanel, "Rabbit");
	
		}
	
	}
