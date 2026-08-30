package view;

import java.awt.EventQueue;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Dashboard;
	private JPanel Controlpanel;
	private CardLayout cardLayout;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setBackground(new Color(128, 128, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 550);
		setResizable(false);
		Dashboard = new JPanel();
		Dashboard.setBackground(new Color(128, 128, 192));
		Dashboard.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Dashboard);
		Dashboard.setLayout(null);
		
		JButton petbutton = new JButton("Pets");
		petbutton.setForeground(new Color(128, 128, 192));
		petbutton.setBackground(new Color(224, 255, 255));
		petbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		petbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(Controlpanel, "Pet");
			}
		});
		petbutton.setBounds(0, 49, 147, 57);
		Dashboard.add(petbutton);
		
		JButton Ownerbutton = new JButton("Owner");
		Ownerbutton.setForeground(new Color(128, 128, 192));
		Ownerbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Ownerbutton.setBackground(new Color(224, 255, 255));
		Ownerbutton.setBounds(0, 103, 147, 57);
		Ownerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(Controlpanel, "Owner");
			}
		});
		
		Dashboard.add(Ownerbutton);
		
		JButton appointmentbutton = new JButton("Appointment");
		appointmentbutton.setHorizontalAlignment(SwingConstants.LEFT);
		appointmentbutton.setForeground(new Color(128, 128, 192));
		appointmentbutton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		appointmentbutton.setBackground(new Color(224, 255, 255));
		appointmentbutton.setBounds(0, 158, 147, 57);
		appointmentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(Controlpanel, "Appointment");
			}
		});
		Dashboard.add(appointmentbutton);

		JButton veterinarianbutton = new JButton("Veterinarians");

		veterinarianbutton.setHorizontalAlignment(SwingConstants.LEFT);
		veterinarianbutton.setForeground(new Color(128, 128, 192));
		veterinarianbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		veterinarianbutton.setBackground(new Color(224, 255, 255));

		veterinarianbutton.setBounds(0, 213, 147, 57);

		veterinarianbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(Controlpanel, "Veterinarian");
			}
		});

		Dashboard.add(veterinarianbutton);

				JButton medicalRecordsButton = new JButton("Medical Records");

		medicalRecordsButton.setHorizontalAlignment(SwingConstants.LEFT);
		medicalRecordsButton.setForeground(new Color(128, 128, 192));
		medicalRecordsButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		medicalRecordsButton.setBackground(new Color(224, 255, 255));

		medicalRecordsButton.setBounds(0, 268, 147, 57);

		medicalRecordsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(Controlpanel, "MedicalRecords");
			}
		});

		Dashboard.add(medicalRecordsButton);
		Controlpanel = new JPanel();
		Controlpanel.setBounds(144, 49, 822, 464);
		Dashboard.add(Controlpanel);
		cardLayout = new CardLayout();
		Controlpanel.setLayout(cardLayout);
		
		JPanel Blankpanel = new JPanel();
		Blankpanel.setBackground(Color.WHITE);
		
		PetsGUI Petpanel = new PetsGUI();
		OwnerGUI Ownerpanel = new OwnerGUI();
		
		
		
AppointmentGUI Appointmentpanel = new AppointmentGUI();
VeterinariansGUI Veterinarianpanel = new VeterinariansGUI();
MedicalRecordsGUI MedicalRecordsPanel = new MedicalRecordsGUI();
		
		Controlpanel.add(Blankpanel, "Dashboard");
		Controlpanel.add(Petpanel, "Pet");
		Controlpanel.add(Ownerpanel, "Owner");
		Controlpanel.add(Appointmentpanel, "Appointment");
		cardLayout.show(Controlpanel, "Dashboard");



	}
}
