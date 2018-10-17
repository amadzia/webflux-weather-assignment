package com.example.webfluxweatherassignment.controllers;

import com.example.webfluxweatherassignment.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Controller
public class WeatherController {


    private ApiService apiService;

    public WeatherController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/weatherforecasts")
    public String formPost(Model model, ServerWebExchange serverWebExchange) {

        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        String city = map.get("city").get(0);
        String countryCode = map.get("countryCode").get(0);

        model.addAttribute("weatherforecasts", apiService.getWeatherForecast(city, countryCode));

        return "weatherforecasts";
    }

}
