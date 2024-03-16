package br.com.af2b.hibernum.domain.repository;

import br.com.af2b.hibernum.domain.model.User;
import br.com.af2b.hibernum.infrastructure.web.dtos.UserDTO;

public interface UserRepository {
    UserDTO createUser(UserDTO userDTO);

    User findById(String id);
}
