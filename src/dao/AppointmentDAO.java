package dao;

import db.DBConnection;
import model.Appoinment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AppointmentDAO {

    public List<Appointment> getAll() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = DBConnection.connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Appointment(rs.getString("appt_id"), rs.getString("date"), rs.getString("time"),
                        rs.getString("pet_id"), rs.getString("service"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Appointment a) {
        String sql = "INSERT INTO appointments(appt_id,date,time,pet_id,service,status) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getApptId());
            ps.setString(2, a.getDate());
            ps.setString(3, a.getTime());
            ps.setString(4, a.getPetId());
            ps.setString(5, a.getService());
            ps.setString(6, a.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Appointment a) {
        String sql = "UPDATE appointments SET date=?, time=?, pet_id=?, service=?, status=? WHERE appt_id=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getDate());
            ps.setString(2, a.getTime());
            ps.setString(3, a.getPetId());
            ps.setString(4, a.getService());
            ps.setString(5, a.getStatus());
            ps.setString(6, a.getApptId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String apptId) {
        String sql = "DELETE FROM appointments WHERE appt_id=?";
        try (Connection conn = DBConnection.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, apptId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String generateId() {
        String sql = "SELECT COUNT(*) AS c FROM appointments";
        try (Connection conn = DBConnection.connect(); Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return "A" + String.format("%03d", rs.getInt("c") + 1);
        } catch (SQLException e) {
            e.printStackTrace();
            return "A000";
        }
    }
}
