package br.com.af2b.hibernum.core.exceptions;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final int status;
    private final String message;

    public CustomException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}