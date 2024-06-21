package weatherstation.observer;

import weatherstation.WeatherData;

public class MockHeatIndexDisplay implements Observer, DisplayElement {
    
    private Float heatIndex;
	private WeatherData weatherData;
    private String data;

    public MockHeatIndexDisplay(WeatherData weatherData) {
        this.heatIndex = computeHeatIndex(weatherData.getTemperature(), weatherData.getHumidity());
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    private Float computeHeatIndex(float t, float rh) {
		float index = (float)((16.923 + (0.185212 * t) + (5.37941 * rh) - (0.100254 * t * rh) 
			+ (0.00941695 * (t * t)) + (0.00728898 * (rh * rh)) 
			+ (0.000345372 * (t * t * rh)) - (0.000814971 * (t * rh * rh)) +
			(0.0000102102 * (t * t * rh * rh)) - (0.000038646 * (t * t * t)) + (0.0000291583 * 
			(rh * rh * rh)) + (0.00000142721 * (t * t * t * rh)) + 
			(0.000000197483 * (t * rh * rh * rh)) - (0.0000000218429 * (t * t * t * rh * rh)) +
			0.000000000843296 * (t * t * rh * rh * rh)) -
			(0.0000000000481975 * (t * t * t * rh * rh * rh)));
		return index;
    }

    @Override
    public void display() {
        data = "" + heatIndex;
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.heatIndex = computeHeatIndex(temp, humidity);
        display();
    }

    public String getData() {
        return data;
    }
}
