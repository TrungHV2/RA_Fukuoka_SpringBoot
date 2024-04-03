package com.ra.api.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseException extends RuntimeException {
    private ErrorMessage errorMessage;
    private ErrorMessageLoader errorMessageLoader = new ErrorMessageLoader();


    public BaseException(String errorCode) {
        super(errorCode);
        errorMessage = new ErrorMessage();
        errorMessage.setCode(errorCode);
        errorMessage.setMessage(errorMessageLoader.getMessage(errorCode));
    }

    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }
}
