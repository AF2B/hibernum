package br.com.af2b.hibernum.core.usecases;

import br.com.af2b.hibernum.infrastructure.web.dtos.UserDTO;

public interface CreateUserUseCase {
    UserDTO execute(UserDTO userDTO);
}
