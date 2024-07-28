package com.example.weather_tg_bot.service.impl;

import com.example.weather_tg_bot.entity.Weather;
import com.example.weather_tg_bot.parser.WeatherParser;
import com.example.weather_tg_bot.service.WeatherService;
import com.example.weather_tg_bot.util.emoji.ObjectEmoji;
import com.example.weather_tg_bot.util.emoji.WeatherEmoji;
import com.example.weather_tg_bot.util.message.MessageText;
import com.vdurmont.emoji.EmojiParser;

public class WeatherServiceImpl implements WeatherService {
    @Override
    public int convertKelvinsToCelsius(int kelvins) {
        int celsius = kelvins - 273;
        return celsius;
    }

    @Override
    public String celsiusToString(int celsius) {
        StringBuilder celsiusStr = new StringBuilder();
        if (celsius > 0) {
            celsiusStr.append("+").append(celsius);
        } else if (celsius < 0) {
            celsiusStr.append("-").append(celsius);
        } else {
            celsiusStr.append(celsius);
        }
        return celsiusStr.toString();
    }

    public String createCurrentWeatherText(String lat, String lon) {
        WeatherParser parser = new WeatherParser();
        Weather weather = parser.readWeatherInfo(lat, lon);
        String weatherText = String.format(MessageText.CURRENT_WEATHER_TEXT, weather.getCountry(), weather.getLocality(), weather.getGeneralTemp(), weather.getPressure(), weather.getHumidity(), weather.getWindSpeed());
        return weatherText;
    }
}
