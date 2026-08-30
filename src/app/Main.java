package app;
import db.DBConnection;
import view.LoginFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Create the SQLite database file + tables (first run only) before
        // showing any UI.
        DBConnection.initialize();

        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
