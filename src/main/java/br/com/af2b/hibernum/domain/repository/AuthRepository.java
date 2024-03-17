package br.com.af2b.hibernum.domain.repository;

import br.com.af2b.hibernum.infrastructure.web.dtos.AuthRequestDTO;

public interface AuthRepository {
    boolean authenticate(AuthRequestDTO authRequestDTO);
}
