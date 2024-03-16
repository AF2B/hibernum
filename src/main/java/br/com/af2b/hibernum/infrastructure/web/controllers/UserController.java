package br.com.af2b.hibernum.infrastructure.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.af2b.hibernum.core.exceptions.ErrorResponse;
import br.com.af2b.hibernum.core.usecases.CreateUserUseCase;
import br.com.af2b.hibernum.infrastructure.web.dtos.UserResponseDTO;
import br.com.af2b.hibernum.infrastructure.web.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Operation(summary = "Cria um usuário", description = "Endpoint para criar um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário criado", content = @Content(schema = @Schema(implementation = UserResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Algum atributo inválido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/users")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO data = createUserUseCase.execute(userDTO);

        UserResponseDTO response = new UserResponseDTO();
        response.setData(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
