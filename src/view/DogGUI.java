package view;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DogGUI extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public DogGUI() {
		setPreferredSize(new Dimension(980, 550));
		setLayout(null);
		
		JButton btnGoldenRetriever = new JButton("Golden Retriever");
		btnGoldenRetriever.setHorizontalAlignment(SwingConstants.LEFT);
		btnGoldenRetriever.setFont(new Font("Century", Font.BOLD, 33));
		btnGoldenRetriever.setBackground(new Color(255, 254, 0));
		btnGoldenRetriever.setBounds(0, 0, 980, 98);
		add(btnGoldenRetriever);
		
		JButton btnGermanShepherd = new JButton("German Shepherd");
		btnGermanShepherd.setHorizontalAlignment(SwingConstants.LEFT);
		btnGermanShepherd.setFont(new Font("Century", Font.BOLD, 33));
		btnGermanShepherd.setBackground(new Color(128, 64, 64));
		btnGermanShepherd.setBounds(0, 94, 980, 98);
		add(btnGermanShepherd);
		
		JButton btnGermanShepherd_1 = new JButton("French Bulldog ");
		btnGermanShepherd_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnGermanShepherd_1.setFont(new Font("Century", Font.BOLD, 33));
		btnGermanShepherd_1.setBackground(new Color(192, 192, 192));
		btnGermanShepherd_1.setBounds(0, 178, 980, 98);
		add(btnGermanShepherd_1);
		
		JButton btnGermanShepherd_1_1 = new JButton("Rottweiler");
		btnGermanShepherd_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnGermanShepherd_1_1.setFont(new Font("Century", Font.BOLD, 33));
		btnGermanShepherd_1_1.setBackground(new Color(107, 1, 165));
		btnGermanShepherd_1_1.setBounds(0, 269, 980, 98);
		add(btnGermanShepherd_1_1);
		
		JButton btnGermanShepherd_1_1_1 = new JButton("Beagle");
		btnGermanShepherd_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnGermanShepherd_1_1_1.setFont(new Font("Century", Font.BOLD, 33));
		btnGermanShepherd_1_1_1.setBackground(new Color(255, 128, 192));
		btnGermanShepherd_1_1_1.setBounds(0, 362, 980, 98);
		add(btnGermanShepherd_1_1_1);

	}

}
