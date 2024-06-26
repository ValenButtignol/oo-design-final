package weatherstation;

import weatherstation.pullobserver.CurrentConditionsDisplay;
import weatherstation.pullobserver.PullObserver;

public class WeatherStationPullVersion {
    
    public static void main (String[] args) {
        WeatherDataPullVersion weatherData = new WeatherDataPullVersion();
        PullObserver currentDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}