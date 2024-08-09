package com.efanov.weather.telegram;

import com.efanov.weather.config.BotProperties;
import com.efanov.weather.service.serviceImpl.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

import static com.efanov.weather.constant.WeatherConst.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final BotProperties botProperties;
    private final WeatherServiceImpl weatherService;
    private final Map<Long, String> userStates = new HashMap<>();

    @Override
    public String getBotUsername() {
        return botProperties.getName();
    }

    @Override
    public String getBotToken() {
        return botProperties.getToken();
    }

    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (message.equalsIgnoreCase(START)) {
                sendMessage(chatId, GREETENGS);
                userStates.put(chatId, AWAITING_CITY);
            } else if (message.equalsIgnoreCase(EXIT) || message.equalsIgnoreCase(EXIT_RU)) {
                sendMessage(chatId, TO_CONTINUE_PLEASE_WRITE_START);
                userStates.remove(chatId);
            } else if (userStates.containsKey(chatId) && userStates.get(chatId).equals(AWAITING_CITY)) {
                startCommandReceived(chatId, message);
            } else {
                sendMessage(chatId, UNKNOWN_COMMAND);
            }
        }
    }


    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.warn(FAILED_TO_SEND_MESSAGE, e);
        }
    }


    private void startCommandReceived(Long chatId, String cityFromText) {
        var weather = weatherService.getWeather(cityFromText);
        if (weather == null) {
            sendMessage(chatId, WRONG_LOCATION_MESSAGE);
        } else {
            sendMessage(chatId, weather.getMessage());
        }
    }

}
