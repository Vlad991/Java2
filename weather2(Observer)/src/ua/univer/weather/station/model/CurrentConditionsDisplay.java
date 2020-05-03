package ua.univer.weather.station.model;

import ua.univer.weather.station.control.IObserver;
import ua.univer.weather.station.control.ISubject;
import ua.univer.weather.station.view.IWeatherView;
import ua.univer.weather.station.view.WeatherViewConsole;

public class CurrentConditionsDisplay implements IObserver {
	WeatherEntity weather;
	IWeatherView viewer;
	
	
	public CurrentConditionsDisplay(ISubject subj) {
		subj.registerObs(this);
		viewer = new WeatherViewConsole(weather);
	}
	
    @Override
	public void update(WeatherEntity weather) {
    	this.weather = weather;
		display();
	}
    
	public void display() {
		System.out.println("*******CurrentDisplay*******");
		viewer.display();
	}

}
