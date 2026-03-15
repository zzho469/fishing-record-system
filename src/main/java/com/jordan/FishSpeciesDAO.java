package com.jordan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FishSpeciesDAO {
    private final String url = "jdbc:mysql://localhost:3306/fishing_db";
    private final String user = "root";
    private final String password = "bb3212333";

    public List<FishSpecies> getAllSpecies() {
        List<FishSpecies> list = new ArrayList<>();
        String sql = "SELECT id, name, image_url FROM fish_species";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                FishSpecies species = new FishSpecies();
                species.setId(rs.getInt("id"));
                species.setName(rs.getString("name"));
                species.setImageUrl(rs.getString("image_url"));
                list.add(species);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
