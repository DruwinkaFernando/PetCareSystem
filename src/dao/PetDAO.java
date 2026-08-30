package dao;

import db.DBConnection;
import model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    public List<Pet> getAll() {
        List<Pet> list = new ArrayList<>();
        String sql = "SELECT * FROM pets";
        try (Connection conn = DBConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Pet(rs.getString("pet_id"), rs.getString("name"), rs.getString("species"),
                        rs.getString("breed"), rs.getInt("age"), rs.getString("gender"), rs.getString("owner_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Pet p) {
        String sql = "INSERT INTO pets(pet_id,name,species,breed,age,gender,owner_id) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getPetId());
            ps.setString(2, p.getName());
            ps.setString(3, p.getSpecies());
            ps.setString(4, p.getBreed());
            ps.setInt(5, p.getAge());
            ps.setString(6, p.getGender());
            ps.setString(7, p.getOwnerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Pet p) {
        String sql = "UPDATE pets SET name=?, species=?, breed=?, age=?, gender=?, owner_id=? WHERE pet_id=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getSpecies());
            ps.setString(3, p.getBreed());
            ps.setInt(4, p.getAge());
            ps.setString(5, p.getGender());
            ps.setString(6, p.getOwnerId());
            ps.setString(7, p.getPetId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String petId) {
        String sql = "DELETE FROM pets WHERE pet_id=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, petId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String generateId() {
        String sql = "SELECT COUNT(*) AS c FROM pets";
        try (Connection conn = DBConnection.connect(); Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return "P" + String.format("%03d", rs.getInt("c") + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "P000";
        }
    }
}
