package pl.domino.weatherstation;

public class FakeTempSensor implements TempSensor {
	public double read() {
		return -14.80;
	
	}
}
