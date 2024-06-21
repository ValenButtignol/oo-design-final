package weatherstation;

import org.junit.jupiter.api.Test;

import weatherstation.observer.MockCurrentConditionsDisplay;

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

    
}