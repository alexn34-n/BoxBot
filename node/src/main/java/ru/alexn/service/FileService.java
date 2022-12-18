package ru.alexn.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.alexn.entity.AppDocument;
import ru.alexn.entity.AppPhoto;
import ru.alexn.service.enums.LinkType;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegMessage);
    String generateLink(Long docId, LinkType linkType);
}
