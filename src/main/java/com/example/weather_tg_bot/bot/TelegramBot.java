package com.example.weather_tg_bot.bot;

import com.example.weather_tg_bot.config.BotConfiguration;
import com.example.weather_tg_bot.exception.TelegramException;
import com.example.weather_tg_bot.keyboard.Keyboard;
import com.example.weather_tg_bot.service.WeatherService;
import com.example.weather_tg_bot.service.impl.WeatherServiceImpl;
import com.example.weather_tg_bot.util.button.ButtonData;
import com.example.weather_tg_bot.util.button.ButtonName;
import com.example.weather_tg_bot.util.command.BaseCommandDescription;
import com.example.weather_tg_bot.util.command.BaseCommandName;
import com.example.weather_tg_bot.util.command.CountryCommand;
import com.example.weather_tg_bot.util.coordinates.CityCoordinates;
import com.example.weather_tg_bot.util.message.MessageText;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {
    private final BotConfiguration config;
    public Keyboard keyboard = new Keyboard();

    public TelegramBot(@Value("${bot.token}") String botToken, BotConfiguration config) throws TelegramException {
        super(botToken);
        this.config = config;
        createMenu();
    }

    public void createMenu() throws TelegramException {
        List<BotCommand> commands = new ArrayList<>();
        BotCommand start = new BotCommand(BaseCommandName.START, BaseCommandDescription.START);
        commands.add(start);
        BotCommand help = new BotCommand(BaseCommandName.HELP, BaseCommandDescription.HELP);
        commands.add(help);

        try {
            this.execute(new SetMyCommands(commands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
    }
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String msgText = update.getMessage().getText();
            if (msgText.equals(BaseCommandName.START)) {
                try {
                    sendGreeting(chatId, update, keyboard.createConfirmButtons());
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(BaseCommandName.HELP)) {
                try {
                    sendMessage(chatId, MessageText.HELP_TEXT);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(ButtonName.CHOOSE)) {
                try {
                    sendMessage(chatId, MessageText.CHOOSE_COUNTRY_AND_CITY, keyboard.createChooseCountryKeyboard());
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.BELARUS_MINSK_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.MINSK_BELARUS_LAT, CityCoordinates.MINSK_BELARUS_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.EGYPT_CAIRO_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.CAIRO_EGYPT_LAT, CityCoordinates.CAIRO_EGYPT_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.CHINA_BEIJING_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.BEIJING_CHINA_LAT, CityCoordinates.BEIJING_CHINA_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.FRANCE_PARIS_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.PARIS_FRANCE_LAT, CityCoordinates.PARIS_FRANCE_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.GERMAN_BERLIN_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.BERLIN_GERMAN_LAT, CityCoordinates.BERLIN_GERMAN_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.ITALY_ROME_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.ROME_ITALY_LAT, CityCoordinates.ROME_ITALY_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.JAPAN_TOKYO_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.TOKIO_JAPAN_LAT, CityCoordinates.TOKIO_JAPAN_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.RUSSIA_MOSCOW_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.MOSCOW_RUSSIA_LAT, CityCoordinates.MOSCOW_RUSSIA_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.SPAIN_MADRID_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.MADRID_SPAIN_LAT, CityCoordinates.MADRID_SPAIN_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.THAILAND_BANGKOK_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.BANGKOK_THAILAND_LAT, CityCoordinates.BANGKOK_THAILAND_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.TURKEY_ANKARA_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.ANKARA_TURKEY_LAT, CityCoordinates.ANKARA_TURKEY_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(CountryCommand.USA_WASHINGTON_COMMAND)) {
                try {
                    sendCurrentWeather(chatId, CityCoordinates.WASHINGTON_USA_LAT, CityCoordinates.WASHINGTON_USA_LON);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (msgText.equals(ButtonName.SHARE)) {
                try {
                    sendLocationRequest(chatId);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else {
                try {
                    sendMessage(chatId, MessageText.UNKNOWN_COMMAND);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            }
        } else if (update.hasCallbackQuery()) {
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            String callbackData = update.getCallbackQuery().getData();
            if (callbackData.equals(ButtonData.YES_DATA)) {
                try {
                    sendMessage(chatId, MessageText.YES_CHOICE_TEXT, keyboard.createChooseKeyboard());
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            } else if (callbackData.equals(ButtonData.NO_DATA)) {
                try {
                    sendMessage(chatId, MessageText.NO_CHOICE_TEXT);
                } catch (TelegramException e) {
                    log.error(e.getMessage());
                    throw new TelegramException(e.getMessage());
                }
            }
        } else if (update.getMessage().hasLocation()) {
            long chatId = update.getMessage().getChatId();
            String lat = String.valueOf(update.getMessage().getLocation().getLatitude());
            String lon = String.valueOf(update.getMessage().getLocation().getLongitude());
            try {
                sendCurrentWeather(chatId, lat, lon);
            } catch (TelegramException e) {
                log.error(e.getMessage());
                throw new TelegramException(e.getMessage());
            }
        }
    }

    private void sendGreeting(long chatId, Update update, InlineKeyboardMarkup keyboardMarkup) throws TelegramException {
        String userName = update.getMessage().getChat().getFirstName();
        String greetingMsg = String.format(MessageText.GREETING_TEXT, userName);
        try {
            sendMessage(chatId, greetingMsg, keyboardMarkup);
        } catch (TelegramException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
    }

    private void sendMessage(long chatId, String text) throws TelegramException {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(text);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
    }

    private void sendMessage(long chatId, String text, InlineKeyboardMarkup keyboardMarkup) throws TelegramException {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(text);
        msg.setReplyMarkup(keyboardMarkup);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
    }

    private void sendMessage(long chatId, String text, ReplyKeyboardMarkup keyboardMarkup) throws TelegramException {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(text);
        msg.setReplyMarkup(keyboardMarkup);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
    }

    private void sendCurrentWeather(long chatId, String lat, String lon) throws TelegramException {
        WeatherService service = new WeatherServiceImpl();
        String cityText = service.createCurrentWeatherText(lat, lon);
        try {
            sendMessage(chatId, cityText);
        } catch (TelegramException e) {
            log.error(e.getMessage());
            throw new TelegramException(e.getMessage());
        }
    }

    private void sendLocationRequest (long chatId) throws TelegramException {
        sendMessage(chatId, MessageText.SHARE_LOCATION, keyboard.createShareLocationKeyboard());
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
