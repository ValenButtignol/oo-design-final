package weatherstation;

import org.junit.jupiter.api.Test;

import weatherstation.observer.MockCelsiusDisplay;
import weatherstation.observer.MockCurrentConditionsDisplay;
import weatherstation.observer.MockHeatIndexDisplay;

public class TestWeatherData {
    
    @Test
    public void testChangingObserversDinamically() {
        WeatherData weatherData = new WeatherData();
	
		MockCurrentConditionsDisplay mockObserver = new MockCurrentConditionsDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
        assert(mockObserver.getData().equals("(80.0, 65.0)"));

		weatherData.setMeasurements(82, 70, 29.2f);
        assert(mockObserver.getData().equals("(82.0, 70.0)"));

		weatherData.setMeasurements(78, 90, 29.2f);
        assert(mockObserver.getData().equals("(78.0, 90.0)"));
    }

    @Test
    public void testFarhenheitToCelsius() {
        WeatherData weatherData = new WeatherData();
        
        MockCelsiusDisplay mockObserver = new MockCelsiusDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        assert(mockObserver.getData().equals("26.666666"));

        weatherData.setMeasurements(82, 70, 29.2f);
        assert(mockObserver.getData().equals("27.777779")); 
    }

    @Test
    public void testHeatIndex() {
        WeatherData weatherData = new WeatherData();
        
        MockHeatIndexDisplay mockObserver = new MockHeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        assert(mockObserver.getData().equals("82.95535"));
        
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println(mockObserver.getData());
        assert(mockObserver.getData().equals("86.90124"));
    }
}