package ua.univer.weather.station;

import ua.univer.weather.station.control.WeatherDataControl;
import ua.univer.weather.station.model.WeatherEntity;
import ua.univer.weather.station.model.display.CurrentDisplay;
import ua.univer.weather.station.view.WeatherViewConsole;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		WeatherDataControl weatherKiev = new WeatherDataControl();
		WeatherDataControl weatherLviv = new WeatherDataControl();
		CurrentDisplay currentDisplayKiev = new CurrentDisplay(weatherKiev);
		CurrentDisplay currentDisplayLviv = new CurrentDisplay(weatherLviv, new WeatherViewConsole());
		CurrentDisplay currentDisplayAll = new CurrentDisplay(weatherKiev);
		currentDisplayAll.setSubject(weatherLviv);
		for (int i = 0; i < 20; i++) {
			weatherKiev.setWeather(new WeatherEntity("Kiev",i, 50+i, 750+i));
			Thread.sleep(400);
			weatherLviv.setWeather(new WeatherEntity(i, 70+i, 850+i));
			Thread.sleep(400);
			if(i==10) currentDisplayAll.setViewer(new WeatherViewConsole());
		}
				

	}

}
