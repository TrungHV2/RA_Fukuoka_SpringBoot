package com.ra.api.exception;

import lombok.Data;

@Data
public class ErrorMessage {
    private String code;
    private String message;
}
