package weatherstation.observer;

import weatherstation.WeatherData;

public class MockCurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
	private float humidity;
	private WeatherData weatherData;
    private String data;
	
	public MockCurrentConditionsDisplay() { };
	
	public MockCurrentConditionsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
	public void display() {
		data = "(" + temperature + ", " + humidity + ")";
	}

	public String getData() {
		return data;
	}
}