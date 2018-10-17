/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.JsonObject;
import converters.JSonConverter;
import dao.WeatherDAO;

/**
 *
 * @author ghersa
 */
public class WeatherService {
    
    WeatherDAO WD = new WeatherDAO();
    
    public JsonObject GetWeather(){
		return JSonConverter.objectToJson(WD.GetWeather());
	}
    
}
