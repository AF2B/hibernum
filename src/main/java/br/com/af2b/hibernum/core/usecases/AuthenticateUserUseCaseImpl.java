package br.com.af2b.hibernum.core.usecases;

import org.springframework.stereotype.Service;

import br.com.af2b.hibernum.domain.repository.AuthRepository;
import br.com.af2b.hibernum.infrastructure.web.dtos.AuthRequestDTO;

@Service
public class AuthenticateUserUseCaseImpl implements AuthenticateUserUseCase {
    private final AuthRepository authRepository;

    public AuthenticateUserUseCaseImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public boolean authenticate(AuthRequestDTO authRequestDTO) {
        return authRepository.authenticate(authRequestDTO);
    }
}
