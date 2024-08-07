package com.efanov.weather.controller;


import com.efanov.weather.model.dto.WeatherDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.efanov.weather.constant.WeatherConst.CITY;
import static com.efanov.weather.constant.WeatherConst.URL;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class WeatherController {

    @GetMapping("{city}")
    public ResponseEntity<Object> getWeatherData(@PathVariable String city){
        String url = URL.replace(CITY, city);
        RestTemplate restTemplate = new RestTemplate();
        WeatherDTO weatherData;
        try {
            weatherData = restTemplate.getForObject(url, WeatherDTO.class);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        }
        return ResponseEntity.ok(weatherData);
    }
}
