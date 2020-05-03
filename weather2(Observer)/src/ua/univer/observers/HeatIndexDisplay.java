package ua.univer.observers;

import ua.univer.weather.station.control.IObserver;
import ua.univer.weather.station.control.ISubject;

public class HeatIndexDisplay implements IObserver, DisplayElement {
	
	private float temperature;
	private float humidity;
	private ISubject weatherData;
	private float heatindex;
	
	public HeatIndexDisplay(ISubject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObs(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		heatindex = (float) (0.0159529 * temp * humidity);
		display();
	}
	
	@Override
	public void display() {
		System.out.println("Heat index is " + heatindex);
	}
	
}
