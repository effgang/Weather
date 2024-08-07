package com.efanov.weather.constant;

public class WeatherConst {
    public static final String URL = "http://api.weatherapi.com/v1/current.json?q={city}&key=7f2030334a3c459bb7f172929240408";
    public static final String WRONG_LOCATION_MESSAGE = "Unfortunately, we can't get weather in your location.";
    public static final String START = "/start";
    public static final String AWAITING_CITY = "AWAITING_CITY";
    public static final String GREETENGS = "Please enter the city name for which you want to know the current weather";
    public static final String UNKNOWN_COMMAND = "Unknown command. Please use /start to begin.";
    public static final String FAILED_TO_SEND_MESSAGE = "Failed to send message";
    public static final String ERROR_GETTING_WEATHER_DATA = "Error getting weather data: {}";
    public static final String CITY = "{city}";
}
