package ua.univer.weather.station.control;

import java.util.ArrayList;

import ua.univer.weather.station.model.WeatherEntity;

public class WeatherDataControl implements ISubject {
	
	private WeatherEntity weather;
	private ArrayList<IObserver> observers;
	
	public WeatherDataControl() {
		observers = new ArrayList();
	}
	
    @Override
	public void registerObs(IObserver obs) {
		observers.add(obs);
		
	}
    
    @Override
	public void removeObs(IObserver o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
		
	}
    	
    @Override
	public void notifyObs() {
    	for (int i = 0; i < observers.size(); i++) {
			IObserver observer = (IObserver)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
    	
	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}

	public void measurementsChanged() {
		notifyObs();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
}
