package com.fernedix.ticketmanagement.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "RegisterResponse",
        description = "Response returned after a successful user registration."
)
public record RegisterResponse(

        @Schema(
                description = "User identifier.",
                example = "1"
        )
        Long id,

        @Schema(
                description = "User first name.",
                example = "John"
        )
        String firstName,

        @Schema(
                description = "User last name.",
                example = "Doe"
        )
        String lastName,

        @Schema(
                description = "User email address.",
                example = "john.doe@example.com"
        )
        String email,

        @Schema(
                description = "User phone number.",
                example = "+593987654321"
        )
        String phoneNumber,

        @Schema(
                description = "Indicates whether the account is enabled.",
                example = "true"
        )
        boolean enabled

) {
}