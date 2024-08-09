package com.efanov.weather.constant;


public class WeatherConst {
    public static final String URL = "http://api.weatherapi.com/v1/current.json?q={city}&key=";
    public static final String WRONG_LOCATION_MESSAGE = "Unfortunately, we can't get weather in your location.";
    public static final String START = "/start";
    public static final String AWAITING_CITY = "AWAITING_CITY";
    public static final String GREETENGS = "Please enter the city name for which you want to know the current weather. To stop the bot write exit";
    public static final String UNKNOWN_COMMAND = "Unknown command. Please use /start to begin.";
    public static final String FAILED_TO_SEND_MESSAGE = "Failed to send message";
    public static final String ERROR_GETTING_WEATHER_DATA = "Error getting weather data: {}";
    public static final String CITY = "{city}";
    public static final String KEY = "weather.key";
    public static final String EXIT = "exit";
    public static final String EXIT_RU = "выход";
    public static final String TO_CONTINUE_PLEASE_WRITE_START = "To continue please write /start";
}
