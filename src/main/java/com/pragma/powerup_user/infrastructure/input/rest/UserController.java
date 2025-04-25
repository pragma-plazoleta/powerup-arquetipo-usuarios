package com.pragma.powerup_user.infrastructure.input.rest;

import com.pragma.powerup_user.application.dto.request.UserRequestDto;
import com.pragma.powerup_user.application.handler.IUserHandler;
import com.pragma.powerup_user.infrastructure.util.InfraConstans;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final IUserHandler iUserHandler;

    public UserController(IUserHandler iUserHandler) {
        this.iUserHandler = iUserHandler;
    }

    @Operation(summary = "Add a new owner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Owner created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Owner already exists", content = @Content)
    })
    @PostMapping("/createOwner")
    public ResponseEntity<String> saveOwner(@RequestBody UserRequestDto userRequestDto,
                                         @RequestHeader Map<String, String> header) {
        iUserHandler.saveOwner(userRequestDto, header);
        return new ResponseEntity<>(InfraConstans.RESPONSE_CREATE_OWNER,HttpStatus.CREATED);
    }
}
