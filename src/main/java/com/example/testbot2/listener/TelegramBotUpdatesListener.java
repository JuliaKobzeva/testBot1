package com.example.testbot2.listener;

import com.example.testbot2.enams.ProbationaryStatus;
import com.example.testbot2.handlers.CallBackQueryHandler;
import com.example.testbot2.handlers.Handler;
import com.example.testbot2.handlers.ImageHandler;
import com.example.testbot2.keyboard.InlineKeyboard;
import com.example.testbot2.model.Owner;
import com.example.testbot2.service.OwnerService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.PhotoSize;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {

    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final TelegramBot telegramBot;
    private final OwnerService ownerService;

    public TelegramBotUpdatesListener(TelegramBot telegramBot, OwnerService ownerService) {
        this.telegramBot = telegramBot;
        this.ownerService = ownerService;
    }


    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        try {
            updates.forEach(update -> {
                logger.info("Processing update: {}", update);
                if (update.callbackQuery() != null) {
                    Handler callBackHandler = new CallBackQueryHandler(telegramBot);
                    try {
                        callBackHandler.handle(update);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return;
                }

                if (update.message().photo() != null) {
                    Handler imageHandler = new ImageHandler(telegramBot, ownerService);
                    try {
                        imageHandler.handle(update);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                if ("/start".equals(update.message().text())) {
                    InlineKeyboard inlineKeyboard = new InlineKeyboard(telegramBot);
                    inlineKeyboard.showStartMenu(telegramBot, update.message().chat().id());
                }

            });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}

