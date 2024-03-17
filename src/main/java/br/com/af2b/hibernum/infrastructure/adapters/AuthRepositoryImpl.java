package br.com.af2b.hibernum.infrastructure.adapters;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.com.af2b.hibernum.domain.repository.AuthRepository;
import br.com.af2b.hibernum.infrastructure.web.dtos.AuthRequestDTO;

@Repository
public class AuthRepositoryImpl implements AuthRepository {
    private final MongoTemplate mongoTemplate;
    private static final String COLLECTION = "users";

    public AuthRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public boolean authenticate(AuthRequestDTO authRequestDTO) {
        Criteria criteria = Criteria.where("email").is(authRequestDTO.getEmail()).and("password")
                .is(authRequestDTO.getPassword());

        Query query = new Query(criteria);

        return mongoTemplate.exists(query, COLLECTION);
    }
}
