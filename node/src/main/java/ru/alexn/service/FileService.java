package ru.alexn.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.alexn.entity.AppDocument;

public interface FileService {
    AppDocument processDoc(Message externalMessage);
}
