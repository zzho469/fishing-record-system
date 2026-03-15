package com.jordan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDAO {
    private final String url = "jdbc:mysql://localhost:3306/fishing_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=UTF-8";
    private final String user = "root";
    private final String password = "bb3212333";

    public List<Record> getAllRecords() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");  // 加载驱动

        List<Record> records = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM records")) {

            while (rs.next()) {
                Record r = new Record();
                r.setId(rs.getInt("id"));
                r.setDate(rs.getString("date"));
                r.setLocation(rs.getString("location"));
                r.setFishType(rs.getString("fish_type"));
                r.setSizeCm(rs.getInt("size_cm"));
                r.setBaitUsed(rs.getString("bait_used"));
                r.setNotes(rs.getString("notes"));
                records.add(r);
            }
        }
        return records;
    }

    public void addRecord(Record r) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");  // 加载驱动

        String sql = "INSERT INTO records(date, location, fish_type, size_cm, bait_used, notes) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, r.getDate());
            ps.setString(2, r.getLocation());
            ps.setString(3, r.getFishType());
            ps.setInt(4, r.getSizeCm());
            ps.setString(5, r.getBaitUsed());
            ps.setString(6, r.getNotes());
            ps.executeUpdate();
        }
    }
    public List<Record> getRecordsBySpecies(String fishType) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        List<Record> records = new ArrayList<>();

        String sql = "SELECT * FROM records WHERE fish_type = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, fishType);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Record r = new Record();

                r.setId(rs.getInt("id"));
                r.setDate(rs.getString("date"));
                r.setLocation(rs.getString("location"));
                r.setFishType(rs.getString("fish_type"));
                r.setSizeCm(rs.getInt("size_cm"));
                r.setBaitUsed(rs.getString("bait_used"));
                r.setNotes(rs.getString("notes"));

                records.add(r);
            }
        }

        return records;
    }
}
