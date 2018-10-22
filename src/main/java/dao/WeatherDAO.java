 
package dao;

import configuration.Connexion;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List; 
import status.Reponse;
import models.Weather;
/**
 *
 * @author ghersa
 */
public class WeatherDAO {
    
    private Connection db;
    
    public Reponse GetWeather(){
        List<Weather> res = new ArrayList(); 
        Weather tmp ;
        try {
            db = Connexion.getConnection();
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Weather ");
            while (rs.next()) {
                tmp = new Weather();
                tmp.setDated(rs.getString("Dated"));
                tmp.setDegree(rs.getString("Degree"));
                tmp.setDescription(rs.getString("Description"));
                tmp.setWeatherId(rs.getInt("WeatherId"));

                res.add(tmp);
            }

            stmt.close();
            db.close();
        } catch (URISyntaxException e) {
        	e.printStackTrace();
            return new Reponse("ko", "Erreur sur le serveur");
        } catch (SQLException e) {
        	e.printStackTrace();
            return new Reponse("ko", "Erreur sur le serveur");
        }
        return new Reponse("ok", res);
    }
    
}
