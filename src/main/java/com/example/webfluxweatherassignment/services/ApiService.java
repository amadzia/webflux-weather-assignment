package com.example.webfluxweatherassignment.services;

import com.example.api.v1.domain.WeatherForecast;

public interface ApiService {

    WeatherForecast getWeatherForecast(String cityName, String countryCode);
}
