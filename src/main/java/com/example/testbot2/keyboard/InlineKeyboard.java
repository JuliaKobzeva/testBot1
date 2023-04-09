package com.example.testbot2.keyboard;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

public class InlineKeyboard {
    private final TelegramBot telegramBot;

    public InlineKeyboard(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void showStartMenu(TelegramBot telegramBot,
                              Long chatId) {
        String text = "Привет," +
                " Вас приветствует помощник приложения Help-Pets," +
                " пожалуйста выберите пункт из представленного меню ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Узнать информацию о приюте");
        firstButton.callbackData("Кнопка 1");
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Как взять собаку из приюта");
        secondButton.callbackData("Кнопка 2");
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Прислать отчет о питомце");
        thirdButton.callbackData("Кнопка 3");
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Позвать волонтера");
        fourthButton.callbackData("Кнопка 4");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    public void showInfoShelterMenu(Long chatId) {
        String text = " Вы зашли в раздел  информации о приюте," +
                " пожалуйста выберите пункт из представленного меню ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Подробная информация о приюте");
        firstButton.callbackData("Кнопка 1.1");
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Контактая информация");
        secondButton.callbackData("Кнопка 1.2");
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Рекомендации" +
                " о технике безопасности на территории приюта");
        thirdButton.callbackData("Кнопка 1.3");
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Записать" +
                "контактные данные для связи");
        fourthButton.callbackData("Кнопка 1.4");
        InlineKeyboardButton fifthButton = new InlineKeyboardButton("Позвать волонтера");
        fifthButton.callbackData("Кнопка 1.5");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        inlineKeyboardMarkup.addRow(fifthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    public void showReportMenu(Long chatId) {
        String text = " Здесь вы можете отправить отчет о своем питомце," +
                " пожалуйста выберите пункт из представленного меню ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Форма ежедневного отчета");
        firstButton.callbackData("Кнопка 3.1");
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Отправить отчет");
        secondButton.callbackData("Кнопка 3.2");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

}

