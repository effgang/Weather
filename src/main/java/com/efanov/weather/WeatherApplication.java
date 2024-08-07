package com.efanov.weather;

import com.efanov.weather.config.BotProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class WeatherApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WeatherApplication.class, args);

        System.out.println(context.getBean(BotProperties.class));
    }

}
