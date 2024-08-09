package com.efanov.weather.service.serviceImpl;

import com.efanov.weather.model.dto.WeatherDTO;
import com.efanov.weather.service.WeatherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.efanov.weather.constant.WeatherConst.*;

@Component
@AllArgsConstructor
@Slf4j
public class WeatherServiceImpl implements WeatherService {
    private final Environment environment;

    @Override
    public WeatherDTO getWeather(String city) {
        String url = URL.replace(CITY, city) + environment.getProperty(KEY);
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
