package ua.univer.weather.station.control;

import ua.univer.weather.station.model.WeatherEntity;

public interface IObserver {
	void update(WeatherEntity weather);
}
