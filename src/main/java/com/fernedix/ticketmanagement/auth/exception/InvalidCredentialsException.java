package com.fernedix.ticketmanagement.auth.exception;

import com.fernedix.ticketmanagement.common.exception.BusinessException;
import com.fernedix.ticketmanagement.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BusinessException {

    public InvalidCredentialsException() {

        super(
                HttpStatus.UNAUTHORIZED,
                ErrorCode.INVALID_CREDENTIALS,
                "Invalid email or password."
        );

    }

}