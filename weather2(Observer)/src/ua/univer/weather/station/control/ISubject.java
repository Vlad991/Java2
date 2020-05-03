package ua.univer.weather.station.control;

public interface ISubject {
	public void registerObs(IObserver o);
	public void removeObs(IObserver o);
	public void notifyObs();
}
