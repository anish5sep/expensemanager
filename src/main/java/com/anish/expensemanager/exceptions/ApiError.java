package com.anish.expensemanager.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private int status;

    public ApiError(LocalDateTime timestamp, String message, String path, int status) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.status = status;
    }

}
