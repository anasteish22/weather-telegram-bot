package com.example.weather_tg_bot.reader;

import com.example.weather_tg_bot.exception.TelegramException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class ApiWeatherReader {
//    private final String weatherUri = "https://api.openweathermap.org/data/2.5/weather?lat=53.90454&lon=27.56152&appid=9e663251596736ec3057ecf072edbba4";
    private static final String URL_MODEL = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
    private static final String API_TOKEN = "9e663251596736ec3057ecf072edbba4";
    public HttpResponse<String> readFromUri(String lat, String lon) throws TelegramException {
        String weatherUri = getCurrentWeatherUri(lat, lon);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(weatherUri)).build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
        return response;
    }

    private String getCurrentWeatherUri(String lat, String lon) {
        String weatherUri = String.format(URL_MODEL, lat, lon, API_TOKEN);
        return weatherUri;
    }
}
