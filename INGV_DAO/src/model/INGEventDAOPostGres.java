/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 *
 * @author paolo
 */
public class INGEventDAOPostGres implements INGEventDAO {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASS = "postgres";

    //scorre la lista ed aggiunge al DB
    @Override
    public void carica(List<INGEvent> eventi) throws Exception {
    String sqlQuery = 
        "INSERT INTO eventi ("
      + "event_id, time, latitude, longitude, depth_km, "
      + "author, catalogo, contributor, contributor_id, "
      + "mag_type, magnitude, mag_author, event_location_name, event_type"
      + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            + "ON CONFLICT (event_id) DO NOTHING";

        try (
            Connection c = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement ps = c.prepareStatement(sqlQuery);
        ) {
            for (INGEvent e : eventi) {
                System.out.println("fatto\n");
                ps.setString(1, e.getEventID());
                ps.setObject(2, e.getTime()); 
                ps.setDouble(3, e.getLatitude());
                ps.setDouble(4, e.getLongitude());
                ps.setDouble(5, e.getDepth());
                ps.setString(6, e.getAuthor());
                ps.setString(7, e.getCatalog());
                ps.setString(8, e.getContributor());
                ps.setString(9, e.getContributorID());
                ps.setString(10, e.getMagType());
                ps.setDouble(11, e.getMagnitude());
                ps.setString(12, e.getMagAuthor());
                ps.setString(13, e.getEventLocationName());
                ps.setString(14, e.getEventType());

                ps.executeUpdate();
            }
        }
    }

   @Override
public List<INGEvent> filtra(LocalDateTime dataInizio, LocalDateTime dataFine, int limite) throws Exception {
    
    List<INGEvent> elenco = new ArrayList<>();
    
    String sqlQuery = "SELECT * FROM eventi WHERE time BETWEEN ? AND ? ORDER BY time LIMIT ?";
    
    try (
        Connection c = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = c.prepareStatement(sqlQuery)
    ) {
        ps.setTimestamp(1, Timestamp.valueOf(dataInizio));
        ps.setTimestamp(2, Timestamp.valueOf(dataFine));
        ps.setInt(3, limite);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            INGEvent e = new INGEvent(
                rs.getString("event_id"),
                rs.getTimestamp("time").toLocalDateTime(),
                rs.getDouble("latitude"),
                rs.getDouble("longitude"),
                rs.getDouble("depth_km"),
                rs.getString("author"),
                rs.getString("catalogo"),
                rs.getString("contributor"),
                rs.getString("contributor_id"),
                rs.getString("mag_type"),
                rs.getDouble("magnitude"),
                rs.getString("mag_author"),
                rs.getString("event_location_name"),
                rs.getString("event_type")
            );
            elenco.add(e);
        }
    }
    
    return elenco;
}


    @Override
    public List<INGEvent> elencaTutti() throws Exception {
     List<INGEvent> elenco = new ArrayList();
        
        try(
                Connection c = DriverManager.getConnection(URL, USER, PASS);
                
                Statement st = c.createStatement();
            ) {
            
            String query = String.format("Select * FROM eventi;");
            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()) {
                INGEvent e = new INGEvent(rs.getString("event_id"),rs.getObject("time", java.time.LocalDateTime.class),rs.getDouble("latitude"),rs.getDouble("longitude"),rs.getDouble("depth_km"),rs.getString("author"),rs.getString("catalogo"),rs.getString("contributor"),rs.getString("contributor_id"),rs.getString("mag_type"),rs.getDouble("magnitude"),rs.getString("mag_author"),rs.getString("event_location_name"),rs.getString("event_type"));
                
                elenco.add(e);
            }
        }
        
        return elenco;    }
    
}
