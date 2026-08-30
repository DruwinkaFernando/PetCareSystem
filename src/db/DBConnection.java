package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Single place that knows how to talk to Microsoft SQL Server.
// Requires SQL Server (Express edition is free) running locally with
// SQL Server Authentication enabled - see README.md for setup steps.
public class DBConnection {

    // --- Change these to match your own SQL Server setup if needed ---
    private static final String HOST = "localhost";
    private static final String PORT = "1433";
    private static final String DB_NAME = "petbliss_db";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "YourStrong@Passw0rd";  // set this to the SA password you chose during install
    // -------------------------------------------------------------

    private static final String SERVER_URL =
            "jdbc:sqlserver://" + HOST + ":" + PORT + ";encrypt=true;trustServerCertificate=true;";
    private static final String DB_URL =
            "jdbc:sqlserver://" + HOST + ":" + PORT + ";databaseName=" + DB_NAME + ";encrypt=true;trustServerCertificate=true;";

    // Connects directly to the petbliss_db database (used by every DAO).
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    // Creates the database (if missing), then all 5 tables (if missing),
    // then seeds the 2 default login accounts. Called once on startup
    // from Main.java, before any GUI is shown.
    public static void initialize() {
        // Step 1: connect to the SQL Server instance (no specific database
        // yet) and create the database if it doesn't already exist.
        try (Connection serverConn = DriverManager.getConnection(SERVER_URL, USERNAME, PASSWORD);
             Statement st = serverConn.createStatement()) {
            st.execute("IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = '" + DB_NAME + "') "
                     + "CREATE DATABASE " + DB_NAME);
        } catch (SQLException e) {
            System.err.println("Could not connect to SQL Server. Is it running, and does the SA password match? See README.md.");
            e.printStackTrace();
            return;
        }

        // Step 2: connect to petbliss_db specifically and create tables.
        // SQL Server has no "CREATE TABLE IF NOT EXISTS" shorthand, so we
        // check sys.tables first (the standard T-SQL pattern for this).
        String users = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'users') "
                + "CREATE TABLE users ("
                + "user_id VARCHAR(20) PRIMARY KEY,"
                + "username VARCHAR(50) UNIQUE NOT NULL,"
                + "password VARCHAR(100) NOT NULL,"
                + "full_name VARCHAR(100),"
                + "role VARCHAR(20) NOT NULL)";

        String owners = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'owners') "
                + "CREATE TABLE owners ("
                + "owner_id VARCHAR(20) PRIMARY KEY,"
                + "name VARCHAR(100),"
                + "phone VARCHAR(20),"
                + "email VARCHAR(100),"
                + "address VARCHAR(200))";

        String pets = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'pets') "
                + "CREATE TABLE pets ("
                + "pet_id VARCHAR(20) PRIMARY KEY,"
                + "name VARCHAR(100),"
                + "species VARCHAR(50),"
                + "breed VARCHAR(50),"
                + "age INT,"
                + "gender VARCHAR(10),"
                + "owner_id VARCHAR(20),"
                + "FOREIGN KEY(owner_id) REFERENCES owners(owner_id) ON DELETE SET NULL)";

        String appointments = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'appointments') "
                + "CREATE TABLE appointments ("
                + "appt_id VARCHAR(20) PRIMARY KEY,"
                + "date VARCHAR(20),"
                + "time VARCHAR(20),"
                + "pet_id VARCHAR(20),"
                + "service VARCHAR(50),"
                + "status VARCHAR(20),"
                + "FOREIGN KEY(pet_id) REFERENCES pets(pet_id) ON DELETE SET NULL)";

        String billing = "IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'billing') "
                + "CREATE TABLE billing ("
                + "invoice_no VARCHAR(20) PRIMARY KEY,"
                + "date VARCHAR(20),"
                + "pet_id VARCHAR(20),"
                + "service VARCHAR(50),"
                + "amount FLOAT,"
                + "status VARCHAR(20),"
                + "FOREIGN KEY(pet_id) REFERENCES pets(pet_id) ON DELETE SET NULL)";

        try (Connection conn = connect(); Statement st = conn.createStatement()) {
            st.execute(users);
            st.execute(owners);
            st.execute(pets);
            st.execute(appointments);
            st.execute(billing);

            var rs = st.executeQuery("SELECT COUNT(*) AS c FROM users");
            rs.next();
            if (rs.getInt("c") == 0) {
                st.execute("INSERT INTO users VALUES ('U001','admin','admin123','System Administrator','Admin')");
                st.execute("INSERT INTO users VALUES ('U002','staff','staff123','Dr. Amina Perera','Staff')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
