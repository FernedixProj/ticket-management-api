package com.fernedix.ticketmanagement.common.exception;

public enum ErrorCode {

    // User

    USER_ALREADY_EXISTS,
    ROLE_NOT_FOUND,

    // Authentication

    INVALID_CREDENTIALS,
    INVALID_TOKEN,

    // Validation

    VALIDATION_ERROR,
    MALFORMED_JSON,

    // System

    INTERNAL_SERVER_ERROR

}