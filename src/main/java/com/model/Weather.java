/**
 * Model qui trait les requettes de récupération des donner de météo
 */ 
package com.model;

import com.beans.*;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configuration.connection;

/**
 *
 * @author GHERSA Sofiane
 */

public class Weather {

    WeatherWeek Ww = new WeatherWeek();
    com.beans.Weather W ;
    
    public Weather() { 
        int WeatherId;
        String Dated, Degree, Description;
    
         try {

        Connection db = connection.getConnection();
        Statement stmt = db.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Weather ");
          while (rs.next()) {
            Dated = rs.getString("Dated");
            Degree = rs.getString("Degree");
            Description = rs.getString("Description");
            WeatherId = rs.getInt("WeatherId");
            
            this.W = new com.beans.Weather(WeatherId, Dated, Degree, Description);
            this.Ww.AddWeather(this.W);
 }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.Ww.toString();
    }
    
    
    
}
