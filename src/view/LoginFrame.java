package view;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
    private final JTextField txtUsername;
    private final JPasswordField txtPassword;
    private final UserDAO userDAO = new UserDAO();

    public LoginFrame() {
        setTitle("PetBliss - Pet Care Management System");
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

		
        // ---- Left banner panel (matches the pink illustration side) ----
        JPanel left = new JPanel(new GridBagLayout());
        left.setBackground(UIStyle.CARD_PINK);
        left.setPreferredSize(new Dimension(380, 500));
        JLabel banner = new JLabel(
            "<html><div style='text-align:center;width:260px;'>"
            + "<h1 style='color:#e86883;'>Pet Bliss</h1>"
            + "<p style='color:#333;'>PET CARE MANAGEMENT SYSTEM</p><br>"
            + "<p style='font-size:16px;color:#444;'>Happy Pets<br>Healthy Lives<br>Brighter Tomorrows</p>"
            + "</div></html>");
        left.add(banner);
        add(left, BorderLayout.WEST);

        // ---- Right login form panel ----
        JPanel right = new JPanel(new GridBagLayout());
        right.setBackground(Color.WHITE);
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(8, 10, 8, 10);
        gc.gridwidth = 2;
        gc.gridx = 0;

        JLabel title = new JLabel("Welcome Back!");
        title.setFont(UIStyle.FONT_TITLE);
        gc.gridy = 0;
        right.add(title, gc);

        JLabel sub = new JLabel("Login to continue to a better pet world");
        gc.gridy = 1;
        right.add(sub, gc);

        txtUsername = new JTextField(20);
        txtUsername.setBorder(BorderFactory.createTitledBorder("Username"));
        gc.gridy = 2;
        right.add(txtUsername, gc);

        txtPassword = new JPasswordField(20);
        txtPassword.setBorder(BorderFactory.createTitledBorder("Password"));
        gc.gridy = 3;
        right.add(txtPassword, gc);

        RoundedButton btnLogin = new RoundedButton("Login  ->", UIStyle.SIDEBAR_BG, Color.WHITE);
        btnLogin.setPreferredSize(new Dimension(220, 42));
        gc.gridy = 4;
        right.add(btnLogin, gc);

        JLabel hint = new JLabel("<html><i style='color:gray;'>Demo logins &mdash; Admin: admin / admin123"
            + "&nbsp;&nbsp;|&nbsp;&nbsp;Staff: staff / staff123</i></html>");
        gc.gridy = 5;
        right.add(hint, gc);

        add(right, BorderLayout.CENTER);

        btnLogin.addActionListener(e -> doLogin());
        txtPassword.addActionListener(e -> doLogin());
    }

    private void doLogin() {
        String u = txtUsername.getText().trim();
        String p = new String(txtPassword.getPassword());
        User user = userDAO.authenticate(u, p);
        if (user != null) {
            new DashboardFrame(user).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
	
