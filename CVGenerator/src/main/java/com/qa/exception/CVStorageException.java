package com.qa.exception;

public class CVStorageException extends RuntimeException {
    public CVStorageException(String message) {
        super(message);
    }

    public CVStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}