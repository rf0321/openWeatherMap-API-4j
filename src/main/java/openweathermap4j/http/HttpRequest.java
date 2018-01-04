package openweathermap4j.http;

import openweathermap4j.url.OpenWeatherMapApiUrl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    /* Http Request Method */
    private static String GET = "GET";

    private String api_key;

    public HttpRequest(String api_key){
        this.api_key = api_key;
    }

    public String urlBuilderForCurrent(String location) {

        String buildUrlForApi = OpenWeatherMapApiUrl.END_POINT + "weather?q=" + location + "&appid=" + api_key;

        return httpRequestSender(buildUrlForApi);
    }

    public String urlBuilderForForCast(String location){

        String buildUrlForApi = OpenWeatherMapApiUrl.END_POINT + "forecast?q=" +location+ "&appid="+ api_key;

        return httpRequestSender(buildUrlForApi);
    }

    private static String httpRequestSender(String url) {

        try {
            URL requesturl = new URL(url);

            HttpURLConnection urlConnection = (HttpURLConnection) requesturl.openConnection();

            urlConnection.setRequestMethod(GET);
            urlConnection.setRequestProperty("ContentType", "application/json");
            urlConnection.connect();

            return receiveHttpResponseJson(urlConnection);

        } catch (Exception e) {
            return "http error:" + e.toString();
        }
    }

    private static String receiveHttpResponseJson(HttpURLConnection connection) throws Exception{

        InputStreamReader isr = connection.getResponseCode() == HttpURLConnection.HTTP_OK ?
                new InputStreamReader(connection.getInputStream())
                : new InputStreamReader(connection.getErrorStream());

        BufferedReader reader = new BufferedReader(isr);
        StringBuilder builder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
                System.out.println(builder.append(line));
        }

        reader.close();
        return builder.toString();
    }
}
