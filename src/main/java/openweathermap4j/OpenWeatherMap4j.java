package openweathermap4j;

import openweathermap4j.url.ApiUrlBuilder;


public class OpenWeatherMap4j{

    private String apiKey;

    // private String country;

    public OpenWeatherMap4j(String apiKey){
        this.apiKey = apiKey;
    }

    public String getCurrentWeather(String location){
        return ApiUrlBuilder.buildURL(location, "weather", apiKey);
    }

    public String getWeatherForeCast(String location) {
        return ApiUrlBuilder.buildURL(location, "forecast", apiKey);
    }
}