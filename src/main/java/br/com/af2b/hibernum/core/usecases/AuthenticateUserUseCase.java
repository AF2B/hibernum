package br.com.af2b.hibernum.core.usecases;

import br.com.af2b.hibernum.infrastructure.web.dtos.AuthRequestDTO;

public interface AuthenticateUserUseCase {
    boolean authenticate(AuthRequestDTO authRequestDTO);
}
