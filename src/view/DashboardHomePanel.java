package gui;

import dao.*;
import java.awt.*;

public class DashboardHomePanel extends JPanel {
	public DashboardHomePanel(User user) {
		setBackground(UIStyle.LIGHT_BG);
		setLayout(NEW bORDERlAYOUT(20,20));
		setBorder(BorderFactory.createEmptyBorder(25,25,25,25));

		JLabel welcome = new JLabel("Good Day, " + user.getFullName() + "!");
        welcome.setFont(UIStyle.FONT_TITLE);
        add(welcome, BorderLayout.NORTH);

		JPanel cards = new JPanel(new GridLayout(1,4,15,0))
		cards.setOpaque(false);
		cards.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

		cards.add(makeCard("Total Pets", String.valueOf(new PetDAO().getAll().size()), UIStyle.CARD_PINK));
        cards.add(makeCard("Total Owners", String.valueOf(new OwnerDAO().getAll().size()), UIStyle.CARD_BLUE));
        cards.add(makeCard("Appointments", String.valueOf(new AppointmentDAO().getAll().size()), UIStyle.CARD_PURPLE));
        cards.add(makeCard("Invoices", String.valueOf(new BillingDAO().getAll().size()), UIStyle.CARD_GREEN));

		JPanel wrapper =  new JPanel(new BorderLayout());
		wrapper.setOpaque(false);
		wrapper.add(cards,BorderLayout.NORTH);
		add(wrapper,BorderLayout.CENTER);
	}

	private JPanel makeCard(String label, String value, Color bg) {
        RoundedPanel card = new RoundedPanel(20, bg);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        card.setPreferredSize(new Dimension(200, 110));

        JLabel val = new JLabel(value);
        val.setFont(new Font("SansSerif", Font.BOLD, 30));
        JLabel lab = new JLabel(label);
        lab.setFont(UIStyle.FONT_NORMAL);

        card.add(val, BorderLayout.CENTER);
        card.add(lab, BorderLayout.SOUTH);
        return card;
    }
}

	
