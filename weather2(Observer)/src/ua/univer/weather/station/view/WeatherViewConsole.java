package ua.univer.weather.station.view;

import ua.univer.weather.station.model.WeatherEntity;

public class WeatherViewConsole implements IWeatherView{
	private WeatherEntity weather;

	public WeatherViewConsole(WeatherEntity weather) {
		this.weather = weather;
	}

	@Override
	public void display() {
		System.out.println("*************************");
		System.out.println(weather);
		System.out.println("*************************");
	}

}
