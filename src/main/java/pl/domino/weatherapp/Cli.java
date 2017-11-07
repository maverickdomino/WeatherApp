package pl.domino.weatherapp;

import pl.domino.weatherstation.WeatherStation;
import pl.domino.openweatherapi.ApiTempSensor;
import pl.domino.weatherstation.TempSensor;

public class Cli {
	public static void main(String args[]) {
		String city = "Krakow";
		
		TempSensor tempSensor = new ApiTempSensor("http://api.openweathermap.org/data/2.5/weather?q=Krakow&units=metric&APPID=af319cd969dff7d8c42768f6f0d8c979");
		WeatherStation station = new WeatherStation(tempSensor);

		Double temp = station.temperature();

		System.out.printf("Weather in %s: Temp: %s\n",city,temp);	
	}
}
