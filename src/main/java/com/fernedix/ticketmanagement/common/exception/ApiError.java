package com.fernedix.ticketmanagement.common.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

@Schema(
        name = "ApiError",
        description = "Standard error response returned by the API."
)
public record ApiError(

        @Schema(
                description = "Timestamp when the error occurred.",
                example = "2026-08-02T10:15:30-05:00"
        )
        OffsetDateTime timestamp,

        @Schema(
                description = "HTTP status code.",
                example = "400"
        )
        int status,

        @Schema(
                description = "HTTP status description.",
                example = "Bad Request"
        )
        String error,

        @Schema(
                description = "Application-specific error code.",
                example = "VALIDATION_ERROR"
        )
        String code,

        @Schema(
                description = "Human-readable error message.",
                example = "Email must be valid."
        )
        String message,

        @Schema(
                description = "Request path where the error occurred.",
                example = "/api/v1/auth/register"
        )
        String path

) {
}