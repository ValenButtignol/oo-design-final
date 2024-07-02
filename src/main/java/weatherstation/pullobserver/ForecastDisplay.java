package weatherstation.pullobserver;

import weatherstation.PullSubject;
import weatherstation.WeatherDataPullVersion;

public class ForecastDisplay implements PullObserver {
    private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherDataPullVersion weatherData;

	public ForecastDisplay(WeatherDataPullVersion weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

    @Override
    public void update(PullSubject subject) {
		weatherData = (WeatherDataPullVersion) subject;
		this.lastPressure = currentPressure;
		this.currentPressure = weatherData.getPressure();
        display();
    } 

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}