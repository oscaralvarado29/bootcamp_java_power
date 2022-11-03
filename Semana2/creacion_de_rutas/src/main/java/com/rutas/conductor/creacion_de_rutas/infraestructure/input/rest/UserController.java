package com.rutas.conductor.creacion_de_rutas.infraestructure.input.rest;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.UserRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.UserResponse;
import com.rutas.conductor.creacion_de_rutas.applicaton.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserHandler userHandler;

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = @Content),
            @ApiResponse(responseCode = "409", description = "User already exists", content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<Void> saveUserInDB(@RequestBody UserRequest userRequest){
        userHandler.saveUserInDB(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all the users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All users returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAllUsersFromDB(){
        return ResponseEntity.ok(userHandler.getAllUsersFromDB());
    }

    @Operation(summary = "Get a user by his email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/get/{email}")
    public ResponseEntity<UserResponse> getUserFromDBByEmail(@PathVariable(name = "email") String userEmail){
        return ResponseEntity.ok(userHandler.getUserFromDBByEmail(userEmail));
    }

    @Operation(summary = "Update an existing user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PutMapping("/update")
    public ResponseEntity<Void> updateUserInDB(@RequestBody UserRequest userRequest){
        userHandler.updateUserInDB(userRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete an existing user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @DeleteMapping("/delete/{userEmail}")
    public ResponseEntity<Void> deleteUserInDB(@PathVariable String userEmail){
        userHandler.deleteUserInDB(userEmail);
        return ResponseEntity.noContent().build();
    }
}
