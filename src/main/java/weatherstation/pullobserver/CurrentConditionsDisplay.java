package weatherstation.pullobserver;

import weatherstation.WeatherDataPullVersion;
import weatherstation.DisplayElement;
import weatherstation.PullSubject;

public class CurrentConditionsDisplay implements PullObserver, DisplayElement {
	private float temperature;
	private float humidity;
	private WeatherDataPullVersion weatherData;
	
	public CurrentConditionsDisplay() { };
	
	public CurrentConditionsDisplay(WeatherDataPullVersion weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(PullSubject obj) {
		weatherData = (WeatherDataPullVersion) obj;
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}