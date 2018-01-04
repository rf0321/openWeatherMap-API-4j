package openweathermap4j;

import openweathermap4j.http.HttpRequest;

public class OpenWeatherMap4j{

    private String api_key;

    // private String country;

    public OpenWeatherMap4j(String api_key){
        this.api_key = api_key;
    }

    public String getCurrentWeather(String location){

        HttpRequest httpRequest = new HttpRequest(api_key);

        return httpRequest.urlBuilderForCurrent(location);
    }

    public String getWeatherForeCast(String location) {

        HttpRequest httpRequest = new HttpRequest(api_key);

        return httpRequest.urlBuilderForForCast(location);
    }
}