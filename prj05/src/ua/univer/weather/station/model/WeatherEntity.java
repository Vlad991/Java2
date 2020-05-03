package ua.univer.weather.station.model;

public class WeatherEntity {
	private String city; 	
	private float temperature;
	private float humidity;
	private float pressure;
	public WeatherEntity(float temperature, float humidity, float pressure) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	public WeatherEntity(String city, float temperature, float humidity, float pressure) {
		
		this.city = city;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	@Override
	public String toString() {
		if(city == null)
		return "[temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure + "]";
		else return "[City=" +city+" temperature=" + temperature + ", humidity=" + humidity + ", pressure=" + pressure + "]";
	}
	
}
