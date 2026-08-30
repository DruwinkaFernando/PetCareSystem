package view;

import javax.swing.*;
import java.awt.*;

//A JButton painted with rounded corners to match the pink "pill" buttons
public class RoundedButton extends JButton {
  private final Color bg;

  public RoundedButton(String text, Color bg, Color fg) {
    super(text);
    this.bg = bg;
    setForeground(fg);
        setFont(UIStyle.FONT_BOLD);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(bg);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);
        g2.dispose();
        super.paintComponent(g);
    }
}
