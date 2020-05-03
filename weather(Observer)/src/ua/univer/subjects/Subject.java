package ua.univer.subjects;

import ua.univer.observers.Observer;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
