
package controller;

import com.google.gson.JsonObject;
import converters.JSonConverter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import status.Reponse;
import tokens.AutorisationAcess;

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
        models.Weather wt = new models.Weather();
        wt.setWeatherId(10);
        
        
        
        JsonObject obj = JSonConverter.objectToJson(new Reponse("ok", wt) );
        
		
		
		// Envoie de réponse
		resp.println(obj);
		resp.flush();
        
      
        //response.setContentType("application/json");
        //PrintWriter out = response.getWriter();

         
        // appeler le model
       // com.model.Weather Off = new com.model.Weather();
 
        // envoie la réponse au client
        //out.println(Off.toString());
        //out.close();

    }

    
}
