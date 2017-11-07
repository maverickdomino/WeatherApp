package pl.domino.openweatherapi;

import pl.domino.weatherstation.TempSensor;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;

public class ApiTempSensor implements TempSensor {

private String urlStr;
	
	public ApiTempSensor(String urlStr)
	{
	this.urlStr = urlStr;
	}


public double read() {
	String inputLine;
	String obiekt=""; //string przechowujący zawartość strony internetowej
	int index; // do określenia pozycji temperatury w stringu obiekt
	String temperaturaStr = "";
	double temperatura;

	try {
		URL url = new URL(urlStr);

        	BufferedReader in = new BufferedReader(
        	new InputStreamReader(url.openStream()));
	
		while ((inputLine = in.readLine()) != null)
           	 obiekt += inputLine;
        
		}
	catch(IOException e) {
		System.out.println("Błąd");}
        
	index = obiekt.indexOf("temp"); // ustawiam index na początek pierwszego wystąpienia ciągu znaków "temp"

        
	index += 6; // zwiększam o 6 (żeby wskazywał temperaturę)
        
        while(obiekt.charAt(index)!=',') //konkatenuj znaki póki nie napotkasz przecinka (koniec zapisu temperatury)
        {
        	temperaturaStr += obiekt.charAt(index);
        	index++; // zwiększ indeks o 1
        }
        
        temperatura = Double.parseDouble(temperaturaStr);//przeparsuj zapis temperatury ze stringa na double

	return temperatura;
	}
}
