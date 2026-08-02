package com.fernedix.ticketmanagement.user.exception;

import com.fernedix.ticketmanagement.common.exception.BusinessException;
import com.fernedix.ticketmanagement.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BusinessException {

    public UserAlreadyExistsException(String email) {

        super(
                HttpStatus.CONFLICT,
                ErrorCode.USER_ALREADY_EXISTS,
                "A user with email '%s' already exists.".formatted(email)
        );

    }

}