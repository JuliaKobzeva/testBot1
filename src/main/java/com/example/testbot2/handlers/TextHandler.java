package com.example.testbot2.handlers;

import com.example.testbot2.enams.PetType;
import com.example.testbot2.enams.ProbationaryStatus;
import com.example.testbot2.model.Owner;
import com.example.testbot2.service.OwnerService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TextHandler implements Handler {
    private final TelegramBot telegramBot;
    private final OwnerService ownerService;

    public TextHandler(TelegramBot telegramBot, OwnerService ownerService) {
        this.telegramBot = telegramBot;
        this.ownerService = ownerService;
    }

    @Override
    public void handle(Update update) throws IOException {
        Message message = update.message();
        Long chatId = message.chat().id();
        String text = message.text();
        String name = message.chat().firstName();
        LocalDateTime dateOfStartProbation = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        LocalDateTime dateOfEndProbation = dateOfStartProbation.plusDays(30);
        Owner owner = ownerService.findOwnerByChatId(chatId);
        Long VOLUNTEER_CHAT_ID = 5102380657L;

        if (owner != null && text.length() > 100) {
            owner.setStringReport(text);
            ownerService.saveOwner(owner);
            if (owner.getPhotoReport() == null) {
                sendMessage(chatId, "Пожалуйста, добавьте фото к вашему отчету");
            }
            if (text.length() < 100) {
                sendMessage(chatId, "Пожалуйста предоставьте более подробный отчет");
            }
            if(owner.getDateOfLastReport().plusDays(2).isBefore(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))){
                telegramBot.execute(
                        new SendMessage(owner.getChatId(), "Дорогой усыновитель, мы заметили, что вы заполняете отчет не так подробно, " +
                                "как необходимо. Пожалуйста, подойди ответственнее к этому занятию.  " +
                                "В противном случае волонтеры приюта будут обязаны самолично " +
                                "проверять условия  содержания собаки"));

                sendMessage(VOLUNTEER_CHAT_ID, "Усыновитель id: " + owner.getChatId() +
                        " не присылает отчеты в течение двух дней, пожалуйста свяжитесь с ним");
            }
        } else if ("/saveDogOwner".equals(text)) {
            PetType petType = PetType.DOG;
            ownerService.saveNewDogOwner(chatId,
                    name,
                    petType,
                    dateOfStartProbation,
                    dateOfEndProbation,
                    dateOfStartProbation,
                    ProbationaryStatus.ACTIVE);

            sendMessage(chatId, "Вы успешно зарегестрировались, ваши данные" +
                    "\nваше имя: " + name + " \nтип животного: " + petType);
        }
    }

    private void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage(chatId, message);
        telegramBot.execute(sendMessage);
    }

}
