package ru.alexn.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.alexn.entity.AppDocument;
import ru.alexn.entity.AppPhoto;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegMessage);
}
