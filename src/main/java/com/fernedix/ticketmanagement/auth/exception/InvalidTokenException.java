package com.fernedix.ticketmanagement.auth.exception;

import com.fernedix.ticketmanagement.common.exception.BusinessException;
import com.fernedix.ticketmanagement.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends BusinessException {

    public InvalidTokenException() {

        super(
                HttpStatus.UNAUTHORIZED,
                ErrorCode.INVALID_TOKEN,
                "Invalid authentication token."
        );

    }

}