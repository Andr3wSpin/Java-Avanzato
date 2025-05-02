/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
  + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
    public void aggiorna(INGEvent i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public INGEvent cerca(String matricola) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<INGEvent> elencaTutti() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
