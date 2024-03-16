package br.com.af2b.hibernum.core.usecases;

import org.springframework.stereotype.Component;

import br.com.af2b.hibernum.domain.repository.UserRepository;
import br.com.af2b.hibernum.infrastructure.web.dtos.UserDTO;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO execute(UserDTO userDTO) {
        return userRepository.createUser(userDTO);
    }
}
