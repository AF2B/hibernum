package br.com.af2b.hibernum.infrastructure.adapters;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import br.com.af2b.hibernum.core.exceptions.CustomException;
import br.com.af2b.hibernum.domain.model.User;
import br.com.af2b.hibernum.domain.model.enums.Permission;
import br.com.af2b.hibernum.domain.repository.UserRepository;
import br.com.af2b.hibernum.infrastructure.web.dtos.UserDTO;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final MongoTemplate mongoTemplate;
    private static final String COLLECTION = "users";

    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new CustomException(400, "Os dados do usuario nao podem ser nulos.");
        }

        try {
            User user = UserDTO.toUser(userDTO, Permission.USER);

            if (user != null) {
                mongoTemplate.save(user, COLLECTION);
            }

            return userDTO;
        } catch (CustomException e) {
            throw new CustomException(500, "Erro interno ao salvar o usuário no banco de dados");
        }
    }

    @Override
    public User findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
