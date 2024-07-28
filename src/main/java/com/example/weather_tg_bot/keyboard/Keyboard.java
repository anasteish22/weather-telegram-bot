package com.example.weather_tg_bot.keyboard;

import com.example.weather_tg_bot.util.button.ButtonData;
import com.example.weather_tg_bot.util.button.ButtonName;
import com.example.weather_tg_bot.util.command.CountryCommand;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {
    public InlineKeyboardMarkup createConfirmButtons() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();

        InlineKeyboardButton yesButton = new InlineKeyboardButton();
        yesButton.setText(ButtonName.YES);
        yesButton.setCallbackData(ButtonData.YES_DATA);

        InlineKeyboardButton noButton = new InlineKeyboardButton();
        noButton.setText(ButtonName.NO);
        noButton.setCallbackData(ButtonData.NO_DATA);

        row.add(yesButton);
        row.add(noButton);
        rows.add(row);
        keyboardMarkup.setKeyboard(rows);
        return keyboardMarkup;
    }

    public ReplyKeyboardMarkup createChooseKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add(ButtonName.CHOOSE);
        rows.add(row);

        row = new KeyboardRow();
        row.add(ButtonName.SHARE);
        rows.add(row);

        keyboardMarkup.setKeyboard(rows);
        keyboardMarkup.setResizeKeyboard(true);
        return keyboardMarkup;
    }

    public ReplyKeyboardMarkup createChooseCountryKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        row.add(new KeyboardButton(CountryCommand.CHINA_BEIJING_COMMAND));
        row.add(new KeyboardButton(CountryCommand.RUSSIA_MOSCOW_COMMAND));
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(new KeyboardButton(CountryCommand.USA_WASHINGTON_COMMAND));
        row.add(new KeyboardButton(CountryCommand.GERMAN_BERLIN_COMMAND));
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(new KeyboardButton(CountryCommand.BELARUS_MINSK_COMMAND));
        row.add(new KeyboardButton(CountryCommand.ITALY_ROME_COMMAND));
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(new KeyboardButton(CountryCommand.TURKEY_ANKARA_COMMAND));
        row.add(new KeyboardButton(CountryCommand.FRANCE_PARIS_COMMAND));
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(new KeyboardButton(CountryCommand.SPAIN_MADRID_COMMAND));
        row.add(new KeyboardButton(CountryCommand.JAPAN_TOKYO_COMMAND));
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add(new KeyboardButton(CountryCommand.EGYPT_CAIRO_COMMAND));
        row.add(new KeyboardButton(CountryCommand.THAILAND_BANGKOK_COMMAND));
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows);
        keyboardMarkup.setResizeKeyboard(true);
        return keyboardMarkup;
    }

    public ReplyKeyboardMarkup createShareLocationKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText(ButtonName.SHARE);
        button.setRequestLocation(true);
        row.add(button);

        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        keyboardMarkup.setResizeKeyboard(true);
        return keyboardMarkup;
    }
}
