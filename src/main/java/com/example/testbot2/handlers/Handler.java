package com.example.testbot2.handlers;

import com.pengrad.telegrambot.model.Update;

import java.io.IOException;

public interface Handler {
    void handle(Update update) throws IOException;
}
