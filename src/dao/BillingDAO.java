package dao;

import db.DBConnection;
import model.Billing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    public List<Billing> getAll() {
        List<Billing> list = new ArrayList<>();
        String sql = "SELECT * FROM billing";
        try (Connection conn = DBConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Billing(rs.getString("invoice_no"), rs.getString("date"), rs.getString("pet_id"),
                        rs.getString("service"), rs.getDouble("amount"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Billing b) {
        String sql = "INSERT INTO billing(invoice_no,date,pet_id,service,amount,status) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getInvoiceNo());
            ps.setString(2, b.getDate());
            ps.setString(3, b.getPetId());
            ps.setString(4, b.getService());
            ps.setDouble(5, b.getAmount());
            ps.setString(6, b.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Billing b) {
        String sql = "UPDATE billing SET date=?, pet_id=?, service=?, amount=?, status=? WHERE invoice_no=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getDate());
            ps.setString(2, b.getPetId());
            ps.setString(3, b.getService());
            ps.setDouble(4, b.getAmount());
            ps.setString(5, b.getStatus());
            ps.setString(6, b.getInvoiceNo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String invoiceNo) {
        String sql = "DELETE FROM billing WHERE invoice_no=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, invoiceNo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String generateId() {
        String sql = "SELECT COUNT(*) AS c FROM billing";
        try (Connection conn = DBConnection.connect(); Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return "INV" + String.format("%03d", rs.getInt("c") + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "INV000";
        }
    }
}

