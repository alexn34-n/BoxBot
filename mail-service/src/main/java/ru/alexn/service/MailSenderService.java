package ru.alexn.service;

import ru.alexn.dto.MailParams;

public interface MailSenderService {
    void send(MailParams mailParams);
}
