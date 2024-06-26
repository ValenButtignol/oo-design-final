package weatherstation.pullobserver;

import weatherstation.WeatherDataPullVersion;
import weatherstation.DisplayElement;
import weatherstation.PullSubject;

public class MockCurrentConditionsDisplay implements PullObserver, DisplayElement {
    private float temperature;
	private float humidity;
	private WeatherDataPullVersion weatherData;
    private String data;
	
	public MockCurrentConditionsDisplay() { };
	
	public MockCurrentConditionsDisplay(WeatherDataPullVersion weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(PullSubject subject) {
		WeatherDataPullVersion weatherData = (WeatherDataPullVersion) subject;
		this.temperature = weatherData.getTemperature();
		this.humidity = weatherData.getHumidity();
		display();
	}
	
	public void display() {
		data = "(" + temperature + ", " + humidity + ")";
	}

	public String getData() {
		return data;
	}
}