package com.pragma.powerup_user.infrastructure.input.rest;

import com.pragma.powerup_user.application.dto.request.AuthenticationRequestDto;
import com.pragma.powerup_user.application.dto.response.AuthenticationResponseDto;
import com.pragma.powerup_user.application.handler.IAuthHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final IAuthHandler authHandler;

    public AuthController(IAuthHandler authHandler) {
            this.authHandler = authHandler;
        }

    @Operation(summary = "Service Login")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "User exist, token create", content = @Content),
          @ApiResponse(responseCode = "401", description = "Credentials not found", content = @Content)
    })
    @GetMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        return authHandler.autenticate(authenticationRequestDto);
    }
    
}
