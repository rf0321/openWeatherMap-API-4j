package openweathermap4j.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    /* Http Request Method */
    private static final String GET = "GET";

    public static String httpRequestSender(String url) {

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
