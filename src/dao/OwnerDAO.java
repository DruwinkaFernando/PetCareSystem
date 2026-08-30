package dao;

import db.DBConnection;
import model.Owner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {

    public List<Owner> getAll() {
        List<Owner> list = new ArrayList<>();
        String sql = "SELECT * FROM owners";
        try (Connection conn = DBConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Owner(rs.getString("owner_id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("email"), rs.getString("address")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Owner o) {
        String sql = "INSERT INTO owners(owner_id,name,phone,email,address) VALUES(?,?,?,?,?)";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, o.getOwnerId());
            ps.setString(2, o.getName());
            ps.setString(3, o.getPhone());
            ps.setString(4, o.getEmail());
            ps.setString(5, o.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Owner o) {
        String sql = "UPDATE owners SET name=?, phone=?, email=?, address=? WHERE owner_id=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, o.getName());
            ps.setString(2, o.getPhone());
            ps.setString(3, o.getEmail());
            ps.setString(4, o.getAddress());
            ps.setString(5, o.getOwnerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String ownerId) {
        String sql = "DELETE FROM owners WHERE owner_id=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ownerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String generateId() {
        String sql = "SELECT COUNT(*) AS c FROM owners";
        try (Connection conn = DBConnection.connect(); Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return "O" + String.format("%03d", rs.getInt("c") + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "O000";
        }
    }
}

