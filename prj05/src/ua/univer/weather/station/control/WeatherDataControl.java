package ua.univer.weather.station.control;

import java.util.ArrayList;

import ua.univer.weather.station.model.WeatherEntity;

public class WeatherDataControl implements ISubject {
	private WeatherEntity weather;
	private ArrayList<IObserver> observers;
	public WeatherDataControl() {
		observers = new ArrayList<>();
	}
	@Override
	public void registerObs(IObserver obs) {
		observers.add(obs);
		
	}
	@Override
	public void removeObs(IObserver obs) {
		observers.remove(obs);
		
	}
	@Override
	public void notifyObs() {
		for (IObserver obs : observers) {
			obs.update(weather);
		}		
	}
	public void weatherChange(){
		notifyObs();
	}
	public WeatherEntity getWeather() {
		return weather;
	}
	public void setWeather(WeatherEntity weather) {
		this.weather = weather;
		weatherChange();
	}	
}
