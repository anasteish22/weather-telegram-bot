package com.example.weather_tg_bot.util.message;

import com.example.weather_tg_bot.util.command.BaseCommandDescription;
import com.example.weather_tg_bot.util.command.BaseCommandName;
import com.example.weather_tg_bot.util.emoji.*;
import com.vdurmont.emoji.EmojiParser;

public final class MessageText {
    public static final String GREETING_TEXT = EmojiParser.parseToUnicode("Hi, %s, nice to meet you! "+
            FaceEmoji.SMILING_FACE_WITH_HEARTS + "\n" +
            "I'm WeatherBot! I can send you a current weather forecast " +
            WeatherEmoji.WEATHER + "\n" +
            "Would you like to continue? " +
            FaceEmoji.SMILING_FACE_WITH_SMILING_EYES);
    public static final String HELP_TEXT = "This bot is created to send weather forecast.\n\n" +
            "You can execute commands from the main menu on the left or by typing a command:\n\n" +
            "Type:\n" +
            BaseCommandName.START + " to " + BaseCommandDescription.START + "\n" +
            BaseCommandName.HELP + " to " + BaseCommandDescription.HELP + "\n";
    public static final String YES_CHOICE_TEXT = EmojiParser.parseToUnicode("Great! " +
            FaceEmoji.BEAMING_FACE_WITH_SMILING_EYES + "\n" +
            "Would you like to: \n" +
            SignEmoji.TINY_BLACK_SQUARE +
            " Choose from the list of popular countries and their capitals\n" +
            SignEmoji.TINY_BLACK_SQUARE +
            " Share location");
    public static final String CHOOSE_COUNTRY_AND_CITY = "Choose country and city";
    public static final String NO_CHOICE_TEXT = EmojiParser.parseToUnicode("It's a shame that you've decided to give up using WeatherBot " +
            FaceEmoji.PLEADING_FACE +
            EmotionEmoji.BROKEN_HEART +
            "\nHope to see you here again...");
    public static final String CURRENT_WEATHER_TEXT = EmojiParser.parseToUnicode(ObjectEmoji.ROUND_PUSHPIN +
            "%s, %s\nCurrent weather:\n\n" +
            WeatherEmoji.TEMPERATURE + " general temperature: %s°С\n" +
            WeatherEmoji.ARROW_DOWN + " pressure: %shPa\n" +
            WeatherEmoji.WATER_DROP + " humidity: %s%%\n" +
            WeatherEmoji.WIND + " wind speed: %sm/s\n");

    public static final String SHARE_LOCATION = EmojiParser.parseToUnicode("Please share your location " + FaceEmoji.SMILING_FACE_WITH_SMILING_EYES);
    public static final String UNKNOWN_COMMAND = EmojiParser.parseToUnicode("Sorry, command wasn't recognized " +
            FaceEmoji.PLEADING_FACE);
}
