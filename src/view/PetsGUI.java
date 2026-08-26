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

public class PetsGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;

	/**
	 * Create the panel.
	 */
	public PetsGUI() {
		setPreferredSize(new Dimension(980, 550));
		setLayout(null);
		JPanel mainPanel = new JPanel();
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
		btnDog.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cardLayout.show(mainPanel, "Dog");
		    }
		});
		petMenu.add(btnDog);
		
		JButton btnCat = new JButton("Cat");
		btnCat.setHorizontalAlignment(SwingConstants.LEFT);
		btnCat.setBounds(0, 95, 980, 98);
		btnCat.setBackground(new Color(255, 128, 0));
		btnCat.setFont(new Font("Century", Font.BOLD, 33));
		petMenu.add(btnCat);
		
		JButton btnBird = new JButton("Bird");
		btnParrot .setHorizontalAlignment(SwingConstants.LEFT);
		btnParrot .setBounds(0, 193, 980, 98);
		btnParrot .setBackground(new Color(128, 255, 128));
		btnParrot .setFont(new Font("Century", Font.BOLD, 33));
		petMenu.add(btnBird );
		
		mainPanel.add(petMenu, "PetMenu");
		cardLayout.show(mainPanel, "PetMenu");
		

		DogGUI dogPanel = new DogGUI();


		

		mainPanel.add(dogPanel, "Dog");

	}

}
