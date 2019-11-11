package net.sampletestautomation.requests.weather;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sampletestautomation.requests.city.CityResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class Weather {

    //private static String appid = System.getProperty("appid") ;
    private static String appid = "087d01760b63954af88c233a1a19af90";
    private static String weatherResponseString;
    private static String cityResponseString;
    WeatherResponse weatherResponse;
    CityResponse cityResponse;
    String cityId;

    @Step("7 day weather response is generated")
    public void getWeatherForCity(String cityId) {

        weatherResponseString = SerenityRest.with().
                //header("id",cityId).
                //header("appid",this.appid).
                        queryParam("id",cityId).
                        queryParam("appid",this.appid).
                when().get("https://samples.openweathermap.org/data/2.5/forecast/daily").
                then().assertThat().statusCode(200).
                extract().response().asString();
        System.out.println("Weather Response is ");
        System.out.println(weatherResponseString);
        loadWeatherResponse();
    }

    private void loadWeatherResponse() {
        Gson gson = new Gson();
        this.weatherResponse = gson.fromJson(this.weatherResponseString,WeatherResponse.class);
    }


    public WeatherResponse getWeatherResponse(String city) {
        getCityDetails(city);
        getWeatherForCity(getCityId());
        return weatherResponse;
    }


    @Step("city response is generated")
    public CityResponse getCityDetails(String city) {

        cityResponseString = SerenityRest.with().
                //header("city",city).
                //header("appid",this.appid).
                        queryParam("q",city).
                        queryParam("appid",this.appid).
                        //when().get("api.openweathermap.org/data/2.5/weather").
                        when().get("https://api.openweathermap.org/data/2.5/weather").
                        then().assertThat().statusCode(200).
                        extract().response().asString();
        System.out.println("City Response is ");
        System.out.println(cityResponseString);
        loadCityResponse();
        return cityResponse;
    }

    private String getCityId() {
        cityId = String.valueOf(cityResponse.getId());
        return cityId;
    }


    private void loadCityResponse() {
        Gson gson = new Gson();
        this.cityResponse = gson.fromJson(this.cityResponseString,CityResponse.class);
    }
}
