 
package dao;

import configuration.Connexion;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
        
        try {
            db = Connexion.getConnection();
            Weather tmp = new Weather();
            tmp.setDegree("10");
res.add(tmp);
            tmp.setDegree("11");
res.add(tmp);
        } catch (URISyntaxException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        } catch (SQLException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        }
        return new Reponse("ok", res);
    }
    
}
