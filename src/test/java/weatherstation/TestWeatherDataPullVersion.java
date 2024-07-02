package weatherstation;

import org.junit.jupiter.api.Test;

import weatherstation.pullobserver.MockCurrentConditionsDisplay;
import weatherstation.pullobserver.MockForecastDisplay;

public class TestWeatherDataPullVersion {
    @Test
    public void testCurrentConditionsPullVersion() {
        WeatherDataPullVersion weatherData = new WeatherDataPullVersion();
        
        MockCurrentConditionsDisplay mockObserver = new MockCurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        assert(mockObserver.getData().equals("(80.0, 65.0)"));

        weatherData.setMeasurements(82, 70, 29.2f);
        assert(mockObserver.getData().equals("(82.0, 70.0)"));
    }

    @Test
    public void testForecastDisplayPullVersion() {
        WeatherDataPullVersion weatherData = new WeatherDataPullVersion();
        
        MockForecastDisplay mockObserver = new MockForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
        assert(mockObserver.getData().equals("Forecast: Improving weather on the way!"));
		weatherData.setMeasurements(82, 70, 29.2f);
        assert(mockObserver.getData().equals("Forecast: Watch out for cooler, rainy weather"));
		weatherData.setMeasurements(78, 90, 29.2f);
        assert(mockObserver.getData().equals("Forecast: More of the same"));
    }

    @Test
    public void testChangingObserversDinamically() {
        WeatherDataPullVersion weatherData = new WeatherDataPullVersion();
	
		MockCurrentConditionsDisplay conditionsDisplay = new MockCurrentConditionsDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
        assert(conditionsDisplay.getData().equals("(80.0, 65.0)"));

        MockForecastDisplay forecastDisplay = new MockForecastDisplay(weatherData);

		weatherData.setMeasurements(82, 70, 29.2f);
        assert(conditionsDisplay.getData().equals("(82.0, 70.0)"));
        assert(forecastDisplay.getData().equals("Forecast: Watch out for cooler, rainy weather"));
    }
}