package ua.univer.weather.station.view;

import ua.univer.weather.station.model.WeatherEntity;

public class WeatherViewConsole implements IWeatherView {	
	@Override
	public void display(WeatherEntity weather) {
		System.out.println("*****************************");
		System.out.println(weather);
		System.out.println("*****************************");
	}

}
