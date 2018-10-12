/**
 * Représent la météo pour une journée
 */


package com.beans;

/**
 *
 * @author GHERSA Sofiane
 */

public class Weather {
    int WeatherId;
    String Dated, Degree, Description;

    public Weather(int WeatherId, String Dated, String Degree, String Description) {
        this.WeatherId = WeatherId;
        this.Dated = Dated;
        this.Degree = Degree;
        this.Description = Description;
    }

    @Override
    public String toString() {
        String result ="{";
        
        
        result = result.concat("\"WeatherId\" : ");
        result = result.concat("\""+this.WeatherId+"\",");
        result = result.concat("\"Dated\" : ");
        result = result.concat("\""+this.Dated+"\",");
        result = result.concat("\"Degree\" : ");
        result = result.concat("\""+this.Degree+"\",");
        result = result.concat("\"Description\" : ");
        result = result.concat("\""+this.Description+"\"");
        
        result = result.concat("}");
        return result;
    }
    
    
    
}
