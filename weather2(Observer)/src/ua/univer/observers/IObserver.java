package ua.univer.weather.station.control;

import ua.univer.weather.station.model.WeatherEntity;

public interface IObserver {
	public void update(WeatherEntity weather);
}
