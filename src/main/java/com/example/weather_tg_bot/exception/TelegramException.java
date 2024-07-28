package com.example.weather_tg_bot.exception;

public class TelegramException extends Exception {
    public TelegramException() {
        super();
    }

    public TelegramException(String message) {
        super(message);
    }

    public TelegramException(String message, Throwable cause) {
        super(message, cause);
    }

    public TelegramException(Throwable cause) {
        super(cause);
    }
}
