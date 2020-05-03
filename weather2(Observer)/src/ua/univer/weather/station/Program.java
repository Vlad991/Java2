package ua.univer.weather.station;

import ua.univer.weather.station.control.WeatherDataControl;
import ua.univer.weather.station.model.CurrentConditionsDisplay;

public class Program {

	public static void main(String[] args) {
		WeatherDataControl weatherKiev = new WeatherDataControl();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherKiev);
		
		
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}

}
