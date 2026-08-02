package com.fernedix.ticketmanagement.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(
        name = "RegisterRequest",
        description = "Request body used to register a new user."
)
public record RegisterRequest(

        @Schema(
                description = "User first name.",
                example = "John",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "First name is required.")
        @Size(max = 100, message = "First name must not exceed 100 characters.")
        String firstName,

        @Schema(
                description = "User last name.",
                example = "Doe",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "Last name is required.")
        @Size(max = 100, message = "Last name must not exceed 100 characters.")
        String lastName,

        @Schema(
                description = "User email address.",
                example = "john.doe@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "Email is required.")
        @Email(message = "Email must be valid.")
        @Size(max = 150, message = "Email must not exceed 150 characters.")
        String email,

        @Schema(
                description = "User password.",
                example = "MySecurePassword123",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "Password is required.")
        @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters.")
        String password,

        @Schema(
                description = "User phone number.",
                example = "+593987654321",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "Phone number is required.")
        @Pattern(
                regexp = "^\\+?[0-9]{7,15}$",
                message = "Phone number format is invalid."
        )
        String phoneNumber

) {
}