package com.fernedix.ticketmanagement.auth.controller;

import com.fernedix.ticketmanagement.auth.dto.RegisterRequest;
import com.fernedix.ticketmanagement.auth.dto.RegisterResponse;
import com.fernedix.ticketmanagement.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fernedix.ticketmanagement.common.exception.ApiError;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(
        name = "Authentication",
        description = "Endpoints for user authentication and registration."
)
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(
            summary = "Register a new user",
            description = "Creates a new customer account in the system."
    )
    @ApiResponses({

            @ApiResponse(
                    responseCode = "201",
                    description = "User successfully registered.",
                    content = @Content(
                            schema = @Schema(implementation = RegisterResponse.class)
                    )
            ),

            @ApiResponse(
                    responseCode = "400",
                    description = "Validation failed.",
                    content = @Content(
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),

            @ApiResponse(
                    responseCode = "409",
                    description = "Email already exists.",
                    content = @Content(
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),

            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error.",
                    content = @Content(
                            schema = @Schema(implementation = ApiError.class)
                    )
            )

    })
    public ResponseEntity<RegisterResponse> register(
            @Valid @RequestBody RegisterRequest request
    ) {

        RegisterResponse response = authService.register(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}