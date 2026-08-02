package com.fernedix.ticketmanagement.user.exception;

import com.fernedix.ticketmanagement.common.exception.BusinessException;
import com.fernedix.ticketmanagement.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends BusinessException {

    public RoleNotFoundException(String role) {

        super(
                HttpStatus.NOT_FOUND,
                ErrorCode.ROLE_NOT_FOUND,
                "Role '%s' was not found.".formatted(role)
        );

    }

}