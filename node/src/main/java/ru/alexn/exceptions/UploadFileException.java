package ru.alexn.exceptions;

public class UploadFileException extends RuntimeException {
    public UploadFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public UploadFileException(String message) {
        super(message);
    }

    public UploadFileException(Throwable cause) {
        super(cause);
    }
}
