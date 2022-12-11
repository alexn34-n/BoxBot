package ru.alexn.service;

import org.springframework.core.io.FileSystemResource;
import ru.alexn.entity.AppDocument;
import ru.alexn.entity.AppPhoto;
import ru.alexn.entity.BinaryContent;

public interface FileService {
    AppDocument getDocument(String id);
    AppPhoto  getPhoto(String id);
    FileSystemResource getFileSystemResource(BinaryContent binaryContent);
}
