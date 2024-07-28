package com.example.weather_tg_bot.entity;

import lombok.Data;

@Data
public class Weather {
    private String country;
    private String locality;
    private int generalTemp;
    private int pressure;
    private int humidity;
    private double windSpeed;
}
