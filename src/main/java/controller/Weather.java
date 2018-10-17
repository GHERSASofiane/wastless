
package controller;

import com.google.gson.JsonObject;
import converters.JSonConverter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.WeatherService;
import status.Reponse; 

/**
 *
 * @author ghersa
 */
public class Weather  extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();

        // Préparer la répense
        WeatherService WS = new WeatherService();

        // Envoie de réponse
        resp.println(WS.GetWeather());
        resp.flush();

    }

    
}
