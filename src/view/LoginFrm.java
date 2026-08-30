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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertextfield;
	private JPasswordField passwordtextfield;

	private JButton petOwnerToggle;
	private JButton adminToggle;

	
	private String selectedRole = "PET_OWNER";


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


	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 620);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 240)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel card = new JPanel();
		card.setBackground(Color.WHITE);
		card.setBorder(new LineBorder(new Color(225, 225, 225)));
		card.setBounds(40, 30, 400, 500);
		contentPane.add(card);
		card.setLayout(null);

		
		JLabel pawIcon = new JLabel("\uD83D\uDC3E");
		pawIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
		pawIcon.setForeground(new Color(255, 165, 2));
		pawIcon.setHorizontalAlignment(SwingConstants.CENTER);
		pawIcon.setBounds(0, 25, 400, 40);
		card.add(pawIcon);

		
		JLabel lblPetCareSystem = new JLabel("Pet care management system");
		lblPetCareSystem.setForeground(new Color(255, 128, 0));
		lblPetCareSystem.setFont(new Font("Arial", Font.BOLD, 18));
		lblPetCareSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetCareSystem.setBounds(0, 65, 400, 30);
		card.add(lblPetCareSystem);

		
		petOwnerToggle = new JButton("Pet owner");
		petOwnerToggle.setFont(new Font("Arial", Font.BOLD, 13));
		petOwnerToggle.setBounds(30, 120, 165, 32);
		petOwnerToggle.setFocusPainted(false);
		card.add(petOwnerToggle);

		adminToggle = new JButton("Admin");
		adminToggle.setFont(new Font("Arial", Font.PLAIN, 13));
		adminToggle.setBounds(195, 120, 165, 32);
		adminToggle.setFocusPainted(false);
		card.add(adminToggle);

		petOwnerToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedRole("PET_OWNER");
			}
		});

		adminToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSelectedRole("ADMIN");
			}
		});

		//Username
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 13));
		lblUsername.setBounds(30, 175, 200, 20);
		card.add(lblUsername);

		usertextfield = new JTextField();
		usertextfield.setFont(new Font("Calibri", Font.PLAIN, 14));
		usertextfield.setBounds(30, 198, 330, 32);
		usertextfield.setBorder(new LineBorder(new Color(210, 210, 210)));
		card.add(usertextfield);
		usertextfield.setColumns(10);

		//Password 
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 13));
		lblPassword.setBounds(30, 245, 200, 20);
		card.add(lblPassword);

		passwordtextfield = new JPasswordField();
		passwordtextfield.setFont(new Font("Calibri", Font.PLAIN, 14));
		passwordtextfield.setBounds(30, 268, 330, 32);
		passwordtextfield.setBorder(new LineBorder(new Color(210, 210, 210)));
		card.add(passwordtextfield);
		passwordtextfield.setColumns(10);

		//Login
		JButton loginbutton = new JButton("Log in");
		loginbutton.setFont(new Font("Arial", Font.BOLD, 14));
		loginbutton.setForeground(Color.WHITE);
		loginbutton.setBackground(new Color(37, 99, 235));
		loginbutton.setFocusPainted(false);
		loginbutton.setBounds(30, 325, 330, 38);
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLogin();
			}
		});
		card.add(loginbutton);

		//Register
		JButton registerLink = new JButton("New here? Register as a pet owner");
		registerLink.setFont(new Font("Arial", Font.PLAIN, 12));
		registerLink.setForeground(new Color(37, 99, 235));
		registerLink.setBorderPainted(false);
		registerLink.setContentAreaFilled(false);
		registerLink.setFocusPainted(false);
		registerLink.setBounds(30, 375, 330, 25);
		registerLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(LoginForm.this, "Register screen hasn't been build yet. SORRY!!!");
			}
		});
		card.add(registerLink);

		setSelectedRole("PET_OWNER"); 
	}


	private void setSelectedRole(String role) {
		selectedRole = role;

		Color activeBg = new Color(219, 234, 254); 
		Color activeText = new Color(29, 78, 216);
		Color inactiveBg = Color.WHITE;
		Color inactiveText = Color.DARK_GRAY;

		if (role.equals("PET_OWNER")) {
			petOwnerToggle.setBackground(activeBg);
			petOwnerToggle.setForeground(activeText);
			petOwnerToggle.setFont(new Font("Arial", Font.BOLD, 13));

			adminToggle.setBackground(inactiveBg);
			adminToggle.setForeground(inactiveText);
			adminToggle.setFont(new Font("Arial", Font.PLAIN, 13));
		} else {
			adminToggle.setBackground(activeBg);
			adminToggle.setForeground(activeText);
			adminToggle.setFont(new Font("Arial", Font.BOLD, 13));

			petOwnerToggle.setBackground(inactiveBg);
			petOwnerToggle.setForeground(inactiveText);
			petOwnerToggle.setFont(new Font("Arial", Font.PLAIN, 13));
		}
	}


	private void handleLogin() {
		String username = usertextfield.getText().trim();
		String password = new String(passwordtextfield.getPassword());

		if (username.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please enter both username and password.");
			return;
		}

		JOptionPane.showMessageDialog(this, "Logging in as " + selectedRole + "...");

		Dashboard dashboard = new Dashboard();
		dashboard.setVisible(true);
		dispose();
	}
}