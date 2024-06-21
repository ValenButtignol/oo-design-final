package weatherstation;

import weatherstation.pullobserver.PullObserver;

public interface PullSubject {
	public void registerObserver(PullObserver o);
	public void removeObserver(PullObserver o);
	public void notifyObservers();
}