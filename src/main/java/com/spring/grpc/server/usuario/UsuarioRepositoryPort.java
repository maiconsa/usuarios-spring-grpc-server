package com.spring.grpc.server.usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {
	UsuarioDomain save(UsuarioDomain usuario);

	boolean existsByEmail(String email);
	
	Optional<UsuarioDomain> findById(Long codigo);
}
