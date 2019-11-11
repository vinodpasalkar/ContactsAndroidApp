package net.sampletestautomation.tests.weather;

import net.sampletestautomation.requests.city.CityResponse;
import net.sampletestautomation.requests.weather.Weather;
import net.sampletestautomation.requests.weather.WeatherResponse;

public class WeatherTests {

    Weather weather;
    WeatherResponse weatherResponse;
    CityResponse cityResponse;

    public void LoadWeatherAPI() {
        weather = new Weather();

    }

    public void fetchWeatherForCity(String city) {
        weatherResponse = weather.getWeatherResponse(city);
    }

    public void getHottestDatForCity(String city) {


    }

    public void printMaximumAndMinimumTemperature(String city) {
        cityResponse = weather.getCityDetails(city);
        System.out.println("Maximum temperature in the city is:"+cityResponse.getMain().getTempMax());
        System.out.println("Minimum temperature in the city is:"+cityResponse.getMain().getTempMin());
    }
}
