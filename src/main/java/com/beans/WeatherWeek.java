/**
 * Représent la météo sur une semaine
 */


package com.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GHERSA Sofiane
 */

public class WeatherWeek {
    
    List<Weather> MyListeWeather = new ArrayList<Weather>();
    
    public void AddWeather(Weather param){
        this.MyListeWeather.add(param);
    }

    @Override
    public String toString() {
        String result ="{\"Weather\":[";
        
        for (int i = 0; i < this.MyListeWeather.size()-1; i++) {
            result = result.concat(this.MyListeWeather.get(i).toString()+" , ");
        }
        
            result = result.concat(this.MyListeWeather.get(this.MyListeWeather.size()-1).toString());
            
        result = result.concat("]}");
        return result;
    }
    
    
    
}
