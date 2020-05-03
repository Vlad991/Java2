package ua.univer.weather.station.model.display;

import ua.univer.weather.station.control.IObserver;
import ua.univer.weather.station.control.ISubject;
import ua.univer.weather.station.model.WeatherEntity;
import ua.univer.weather.station.view.IWeatherView;
import ua.univer.weather.station.view.WeatherViewConsole;
import ua.univer.weather.station.view.WeatherViewForm;

public class CurrentDisplay implements IObserver {
	WeatherEntity weather;
	IWeatherView viewer; 

	public CurrentDisplay(ISubject subj) {		
		setSubject(subj);
		viewer = new WeatherViewForm();
	}
	public CurrentDisplay(ISubject subj,IWeatherView viewer) {		
		setSubject(subj);
		setViewer(viewer);
	}
    public void setSubject(ISubject subj) {		
		subj.registerObs(this);		
	}
    public void setViewer(IWeatherView viewer){
    	this.viewer = viewer;
    }
	@Override
	public void update(WeatherEntity weather) {
		this.weather = weather;
		display();
	}
	
	
	public void display(){
		System.out.println("**********CurrentDisplay*******");
		viewer.display(weather);
	}
}
