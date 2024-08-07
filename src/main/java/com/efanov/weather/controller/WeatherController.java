package com.efanov.weather.controller;


import com.efanov.weather.model.entity.WeatherData;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class WeatherController {

    public static final String URL = "http://api.weatherapi.com/v1/current.json?q={city}&key=7f2030334a3c459bb7f172929240408";


    @GetMapping("{city}")
    public ResponseEntity<WeatherData> getWeatherData(@PathVariable String city){
        String url = URL.replace("{city}", city);
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);
        return ResponseEntity.ok(weatherData);
    }
}
