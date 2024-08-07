package com.efanov.weather.service.serviceImpl;

import com.efanov.weather.model.dto.WeatherDTO;
import com.efanov.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.efanov.weather.constant.WeatherConst.*;

@Component
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    @Override
    public WeatherDTO getWeather(String city) {
        String url = URL.replace(CITY, city);
        RestTemplate restTemplate = new RestTemplate();
        WeatherDTO weatherData;
        try {
            weatherData = restTemplate.getForObject(url, WeatherDTO.class);
        } catch (HttpClientErrorException e) {
            log.warn(ERROR_GETTING_WEATHER_DATA, e.getMessage());
            return null;
        }
        return weatherData;
    }
}
