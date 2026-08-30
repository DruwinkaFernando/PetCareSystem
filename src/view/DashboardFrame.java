package gui;

import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardFrame extends JFrame {
    private final User loggedInUser;
    private JPanel contentPanel;
    private CardLayout cardLayout;

    public DashboardFrame(User user) {
        this.loggedInUser = user;
        setTitle("PetBliss Dashboard - Logged in as " + user.getRole());
        setSize(1300, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(buildSidebar(), BorderLayout.WEST);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        contentPanel.add(new DashboardHomePanel(user), "Dashboard");
        contentPanel.add(new PetPanel(), "Pets");
        contentPanel.add(new OwnerPanel(), "Owners");
        contentPanel.add(new AppointmentPanel(), "Appointments");
        if (user.getAccessibleModules().contains("Billing")) {
            contentPanel.add(new BillingPanel(), "Billing");
        }

        add(contentPanel, BorderLayout.CENTER);
        cardLayout.show(contentPanel, "Dashboard");
    }

    // Builds the sidebar dynamically from user.getAccessibleModules().
    // This is where POLYMORPHISM actually changes the UI: an Admin object
    // and a Staff object return different lists, so each role sees a
    // different set of menu buttons, without any if/else on the class type.
    private JPanel buildSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(UIStyle.SIDEBAR_BG);
        sidebar.setPreferredSize(new Dimension(220, 750));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("  PetBliss");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("SansSerif", Font.BOLD, 22));
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);
        logo.setBorder(BorderFactory.createEmptyBorder(20, 5, 20, 10));
        sidebar.add(logo);

        List<String> modules = loggedInUser.getAccessibleModules();
        for (String m : modules) {
            JButton btn = new JButton("  " + m);
            btn.setAlignmentX(Component.LEFT_ALIGNMENT);
            btn.setMaximumSize(new Dimension(220, 45));
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setForeground(Color.WHITE);
            btn.setBackground(UIStyle.SIDEBAR_BG);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setFont(UIStyle.FONT_NORMAL);
            btn.addActionListener(e -> {
                if (m.equals("Reports") || m.equals("Settings")) {
                    JOptionPane.showMessageDialog(this, m + " module - coming soon.");
                } else {
                    cardLayout.show(contentPanel, m);
                }
            });
            sidebar.add(btn);
        }

        sidebar.add(Box.createVerticalGlue());

        JLabel roleLbl = new JLabel("  " + loggedInUser.getFullName());
        roleLbl.setForeground(Color.WHITE);
        roleLbl.setFont(UIStyle.FONT_NORMAL);
        roleLbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(roleLbl);
        JLabel roleLbl2 = new JLabel("  " + loggedInUser.getRole());
        roleLbl2.setForeground(new Color(200, 200, 200));
        roleLbl2.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(roleLbl2);
        sidebar.add(Box.createVerticalStrut(10));

        JButton logout = new JButton("  Logout");
        logout.setForeground(Color.WHITE);
        logout.setBackground(new Color(200, 60, 80));
        logout.setAlignmentX(Component.LEFT_ALIGNMENT);
        logout.setMaximumSize(new Dimension(220, 45));
        logout.setHorizontalAlignment(SwingConstants.LEFT);
        logout.setBorderPainted(false);
        logout.setFocusPainted(false);
        logout.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            dispose();
        });
        sidebar.add(logout);
        sidebar.add(Box.createVerticalStrut(20));

        return sidebar;
    }
}
