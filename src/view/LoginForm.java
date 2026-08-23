package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertextfield;
	private JTextField passwordtextfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setFont(new Font("Arial", Font.BOLD, 17));
		setForeground(new Color(255, 128, 64));
		setBackground(new Color(196, 64, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPetCareSystem = new JLabel("Pet Care Management System");
		lblPetCareSystem.setBounds(215, 10, 480, 66);
		lblPetCareSystem.setVerticalAlignment(SwingConstants.TOP);
		lblPetCareSystem.setForeground(new Color(255, 128, 64));
		lblPetCareSystem.setFont(new Font("Arial", Font.BOLD, 30));
		lblPetCareSystem.setBackground(new Color(255, 128, 64));
		contentPane.add(lblPetCareSystem);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(175, 108, 118, 47);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(185, 165, 136, 66);
		contentPane.add(lblNewLabel_1);
		
		usertextfield = new JTextField();
		usertextfield.setFont(new Font("Calibri", Font.PLAIN, 13));
		usertextfield.setBounds(293, 137, 378, 18);
		contentPane.add(usertextfield);
		usertextfield.setColumns(10);
		
		passwordtextfield = new JTextField();
		passwordtextfield.setToolTipText("");
		passwordtextfield.setFont(new Font("Calibri", Font.PLAIN, 13));
		passwordtextfield.setBounds(293, 192, 378, 18);
		contentPane.add(passwordtextfield);
		passwordtextfield.setColumns(10);
		
		JButton loginbutton = new JButton("Login");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {Dashboard dashboard = new Dashboard();
			dashboard.setVisible(true);
			dispose();
			}
		});
		loginbutton.setFont(new Font("Arial", Font.PLAIN, 13));
		loginbutton.setBounds(587, 249, 84, 20);
		contentPane.add(loginbutton);

	}
}
