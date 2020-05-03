package ua.univer.weather.station.control;

public interface ISubject {
	void registerObs(IObserver obs);
	void removeObs(IObserver obs);
	void notifyObs();
}
