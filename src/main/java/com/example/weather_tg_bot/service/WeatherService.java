package com.example.weather_tg_bot.service;

public interface WeatherService {
    int convertKelvinsToCelsius(int kelvins);
    String celsiusToString(int celsius);
    String createCurrentWeatherText(String lat, String lon);
}
