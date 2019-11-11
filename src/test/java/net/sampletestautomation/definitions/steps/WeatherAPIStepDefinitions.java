package net.sampletestautomation.definitions.steps;

import net.sampletestautomation.tests.weather.WeatherTests;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class WeatherAPIStepDefinitions {

    @Steps
    WeatherTests weatherTests;

    @Given("I have a weather API")
    public void LoadWeatherAPI(){ weatherTests.LoadWeatherAPI(); }

    @When("I get weather for past week for $city")
    public void fetchWeatherForWeek(String city ){
        weatherTests.fetchWeatherForCity(city);
    }

    @When("I get weather for $city")
    public void fetchWeatherForDay(String city ){
        weatherTests.fetchWeatherForCity(city);
    }


    @Then("the hottest day for $city was")
    public void verifyHottestDay(String city){
        weatherTests.getHottestDatForCity(city);
    }

    @Then("the maximum and minimum temperature are shown for $city")
    public void verifyMinAndMaxTemperaute(String city){
        weatherTests.printMaximumAndMinimumTemperature(city);
    }

}
