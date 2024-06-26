package weatherstation;

import java.util.ArrayList;
import java.util.List;
import weatherstation.pullobserver.PullObserver;

public class WeatherDataPullVersion implements PullSubject {
    private List<PullObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherDataPullVersion() {
        observers = new ArrayList<PullObserver>();
    }
    
    public void registerObserver(PullObserver o) {
        observers.add(o);
    }
    
    public void removeObserver(PullObserver o) {
        observers.remove(o);
    }
    
    public void notifyObservers() {
        for (PullObserver observer : observers) {
            observer.update(this);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    }
    
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
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
}