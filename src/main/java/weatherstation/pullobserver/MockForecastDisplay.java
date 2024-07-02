package weatherstation.pullobserver;

import weatherstation.DisplayElement;
import weatherstation.PullSubject;
import weatherstation.WeatherDataPullVersion;

public class MockForecastDisplay implements PullObserver, DisplayElement {
    private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherDataPullVersion weatherData;
    private String data;

	public MockForecastDisplay(WeatherDataPullVersion weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

    @Override
    public void update(PullSubject subject) {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        display();
    } 

	public void display() {
		if (currentPressure > lastPressure) {
			data = "Forecast: Improving weather on the way!";
		} else if (currentPressure == lastPressure) {
			data = "Forecast: More of the same";
		} else if (currentPressure < lastPressure) {
			data = "Forecast: Watch out for cooler, rainy weather";
		}
	}

    public String getData() {
        return data;
    }
}