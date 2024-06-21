package weatherstation.observer;

import weatherstation.WeatherData;
import weatherstation.DisplayElement;

public class MockCelsiusDisplay implements Observer, DisplayElement {

    private float temperature;
	private WeatherData weatherData;
    private String data;
	
	public MockCelsiusDisplay() { };
	
	public MockCelsiusDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		display();
	}
	
    private float convertIntoCelsius(float temperature) {
        return (temperature - 32) * 5/9;
    }

    public String getData() {
        return data;
    }

	public void display() {
		data = "" + convertIntoCelsius(temperature);
	}   
}