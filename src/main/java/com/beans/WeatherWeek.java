
package com.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ghersa
 */
public class WeatherWeek {
    
    List<Weather> MyListeWeather = new ArrayList<Weather>();
    
    public void AddWeather(Weather param){
        this.MyListeWeather.add(param);
    }

    @Override
    public String toString() {
        String result ="{";
        
        for (int i = 0; i < this.MyListeWeather.size()-1; i++) {
            result = result.concat("\" "+this.MyListeWeather.get(i).Dated+"\" :");
            result = result.concat(this.MyListeWeather.get(i).toString()+" , ");
        }
        
            result = result.concat("\" "+this.MyListeWeather.get(this.MyListeWeather.size()-1).Dated+"\" : ");
            result = result.concat(this.MyListeWeather.get(this.MyListeWeather.size()-1).toString());
            
        result = result.concat("}");
        return result;
    }
    
    
    
}
