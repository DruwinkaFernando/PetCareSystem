package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel Dashboard;

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
		Dashboard = new JPanel();
		Dashboard.setBackground(new Color(128, 128, 192));
		Dashboard.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Dashboard);
		Dashboard.setLayout(null);
		
		JButton petbutton = new JButton("Pets");
		petbutton.setForeground(new Color(128, 128, 192));
		petbutton.setBackground(new Color(128, 128, 255));
		petbutton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		petbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		petbutton.setBounds(0, 78, 147, 57);
		Dashboard.add(petbutton);
		
		JButton doctorbutton = new JButton("Doctors");
		doctorbutton.setForeground(new Color(128, 128, 192));
		doctorbutton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		doctorbutton.setBackground(new Color(17, 17, 255));
		doctorbutton.setBounds(0, 130, 147, 57);
		Dashboard.add(doctorbutton);
		
		JButton appointment = new JButton("Appointment");
		appointment.setHorizontalAlignment(SwingConstants.LEFT);
		appointment.setForeground(new Color(128, 128, 192));
		appointment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		appointment.setBackground(new Color(64, 0, 64));
		appointment.setBounds(0, 184, 147, 57);
		Dashboard.add(appointment);

	}

}
