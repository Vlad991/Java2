package ua.univer.observers;

import ua.univer.subjects.Subject;

public class HeatIndexDisplay implements Observer, DisplayElement {
	
	private float temperature;
	private float humidity;
	private Subject weatherData;
	private float heatindex;
	
	public HeatIndexDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
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
