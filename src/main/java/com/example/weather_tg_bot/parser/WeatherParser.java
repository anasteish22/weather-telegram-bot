package com.example.weather_tg_bot.parser;

import com.example.weather_tg_bot.entity.Weather;
import com.example.weather_tg_bot.exception.TelegramException;
import com.example.weather_tg_bot.reader.ApiWeatherReader;
import com.example.weather_tg_bot.service.WeatherService;
import com.example.weather_tg_bot.service.impl.WeatherServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

@Slf4j
public class WeatherParser {
    private static final String MAIN = "main";
    private static final String SYS = "sys";
    private static final String COUNTRY = "country";
    private static final String NAME = "name";
    private static final String TEMP = "temp";
    private static final String PRESSURE = "pressure";
    private static final String HUMIDITY = "humidity";
    private static final String WIND = "wind";
    private static final String SPEED = "speed";
    private final ApiWeatherReader reader = new ApiWeatherReader();
    private final WeatherService weatherService = new WeatherServiceImpl();
    public JsonObject parse(String lat, String lon) throws TelegramException {
        try (JsonReader jsonReader = Json.createReader(new StringReader(reader.readFromUri(lat, lon).body()))){
            JsonObject jsonObject = jsonReader.readObject();
            return jsonObject;
        } catch (TelegramException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
    }

    public Weather readWeatherInfo(String lat, String lon) {
        try {
            JsonObject weatherJson = parse(lat, lon);
            JsonObject weatherMainInfo = (JsonObject) weatherJson.get(MAIN);

            int generalTempKel = Math.round(Float.parseFloat(String.valueOf(weatherMainInfo.get(TEMP))));
            int generalTemp = weatherService.convertKelvinsToCelsius(generalTempKel);

            int pressure = Integer.parseInt(String.valueOf(weatherMainInfo.get(PRESSURE)));
            int humidity = Integer.parseInt(String.valueOf(weatherMainInfo.get(HUMIDITY)));

            JsonObject windInfo = (JsonObject) weatherJson.get(WIND);
            double windSpeed = Double.parseDouble(String.valueOf(windInfo.get(SPEED)));

            JsonObject countryInfo = (JsonObject) weatherJson.get(SYS);
            String countryWithQuotes = String.valueOf(countryInfo.get(COUNTRY));
            String country = removeQuotes(countryWithQuotes);
            String localityWithQuotes = String.valueOf(weatherJson.get(NAME));
            String locality = removeQuotes(localityWithQuotes);

            Weather weather = new Weather();
            weather.setCountry(country);
            weather.setLocality(locality);
            weather.setGeneralTemp(generalTemp);
            weather.setPressure(pressure);
            weather.setHumidity(humidity);
            weather.setWindSpeed(windSpeed);
            return weather;
        } catch (TelegramException e) {
            throw new RuntimeException(e);
        }
    }

    private String removeQuotes(String str) {
        String result = str.replaceAll("\"", "");
        return result;
    }
}
