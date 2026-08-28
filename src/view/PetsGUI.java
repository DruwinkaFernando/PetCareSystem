package view;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PetsGUI extends JPanel
	{
		private static final long serialVersionUID = 1L;
		private CardLayout cardLayout;
		private JPanel mainPanel;
	
		/**
		 * Create the panel.
		 */
		public PetsGUI() 
		{
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
