package ru.alexn.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.alexn.service.UpdateProducer;
import ru.alexn.utils.MessageUtils;

import static ru.alexn.model.RabbitQueue.*;

@Component
@Log4j
public class UpdateController {
    public TelegramBot telegramBot;
    private final MessageUtils messageUtils;
    private UpdateProducer updateProducer;

    public UpdateController(MessageUtils messageUtils) {
        this.messageUtils = messageUtils;
    }

    public  void  registerBot(TelegramBot telegramBot){
        this.telegramBot=telegramBot;
    }
    public void processUpdate(Update update){
        if(update==null){
            log.error("Received update is null");
            return;
        }
        if(update.hasMessage()){
            distributedMessagesByType(update);
        }else {
            log.error("Unsupported message type is received" +update);
        }
    }

    private void distributedMessagesByType(Update update) {
        var message = update.getMessage();
        if(message.hasText()){
            processTextMessage(update);
        }else if (message.hasDocument()){
            processDocMessage(update);
        } else if (message.hasPhoto()) {
            processPhotoMessage(update);
        }else {
            setUnsupportedMessageTypeView(update);
        }
    }

    private void setUnsupportedMessageTypeView(Update update) {
         var sendMessage = messageUtils.generateSendMessageWithText(update,
                 "Unsupported  type of message");
         setView(sendMessage);
    }

    private void setFileReceivedView(Update update) {
        var sendMessage = messageUtils.generateSendMessageWithText(update,
                "The File has received! In progress...");
        setView(sendMessage);
    }

    public void setView(SendMessage sendMessage) {
        telegramBot.sendAnswerMessage(sendMessage);
    }

    private void processPhotoMessage(Update update) {
        updateProducer.producer(PHOTO_MESSAGE_UPDATE,update);
        setFileReceivedView(update);

    }



    private void processDocMessage(Update update) {
        updateProducer.producer(DOC_MESSAGE_UPDATE,update);
        setFileReceivedView(update);
    }

    private void processTextMessage(Update update) {
        updateProducer.producer(TEXT_MESSAGE_UPDATE,update);
        setFileReceivedView(update);
    }
}
