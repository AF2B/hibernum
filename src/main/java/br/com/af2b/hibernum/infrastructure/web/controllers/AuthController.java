package br.com.af2b.hibernum.infrastructure.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.af2b.hibernum.core.exceptions.ErrorResponse;
import br.com.af2b.hibernum.domain.repository.AuthRepository;
import br.com.af2b.hibernum.infrastructure.web.dtos.AuthRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AuthController {
    private final AuthRepository authRepository;

    public AuthController(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Operation(summary = "Authentica um usuário", description = "Endpoint para authenticar o usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário authenticado"),
            @ApiResponse(responseCode = "401", description = "Usuário nao autorizado"),
            @ApiResponse(responseCode = "400", description = "Algum atributo inválido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/auth/login")
    ResponseEntity<Void> auth(@RequestBody AuthRequestDTO authRequestDTO) {
        boolean exists = authRepository.authenticate(authRequestDTO);
        if (exists) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
