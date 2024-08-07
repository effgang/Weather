package com.efanov.weather.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDTO {
    public static class Condition {

        public String text;
    }

    public static class Current {

        public double temp_c;
        public Condition condition;
        public double wind_kph;
        public String wind_dir;
        public int cloud;
        public double feelslike_c;

        @Override
        public String toString() {
            return "temperature: " + temp_c + '\n' +
                    "condition: " + condition.text + '\n' +
                    "wind speed(km/h): " + wind_kph + '\n' +
                    "wind direction: " + wind_dir + '\n' +
                    "cloud: " + cloud + '\n' +
                    "feels like: " + feelslike_c;
        }

    }

    public static class Location {

        public String name;
        public String region;
        public String country;

    }

    public Location location;
    public Current current;

    public String getMessage() {
        return "Weather in " + location.name + ", " + location.country + ":" + '\n' +
                current.toString();
    }
}
