/**
 * Représent la météo pour une journée
 */


package models;

/**
 *
 * @author GHERSA Sofiane
 */

public class Weather {
    int WeatherId;
    String Dated, Degree, Description;

    public void setWeatherId(int WeatherId) {
        this.WeatherId = WeatherId;
    }

    public void setDated(String Dated) {
        this.Dated = Dated;
    }

    public void setDegree(String Degree) {
        this.Degree = Degree;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getWeatherId() {
        return WeatherId;
    }

    public String getDated() {
        return Dated;
    }

    public String getDegree() {
        return Degree;
    }

    public String getDescription() {
        return Description;
    }

   
  
    
    
    
}
