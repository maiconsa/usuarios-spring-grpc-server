package com.spring.grpc.server.adapters.database.jdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.grpc.server.adapters.database.jdbc.entities.UsuarioEntity;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
	boolean existsByEmail(String email);
}
