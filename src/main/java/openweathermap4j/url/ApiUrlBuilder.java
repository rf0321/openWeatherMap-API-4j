package openweathermap4j.url;

import openweathermap4j.http.HttpRequest;

public class ApiUrlBuilder {

    public static String buildURL(String location, String urlparam, String key){

        String requestUrl = OpenWeatherMapApiUrl.END_POINT + urlparam +"?q=" + location + "&appid=" + key;

        return HttpRequest.httpRequestSender(requestUrl);
    }
}
