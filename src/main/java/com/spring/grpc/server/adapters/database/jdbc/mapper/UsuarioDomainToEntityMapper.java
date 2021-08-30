package com.spring.grpc.server.adapters.database.jdbc.mapper;

import org.springframework.stereotype.Component;

import com.spring.grpc.server.adapters.database.jdbc.entities.UsuarioEntity;
import com.spring.grpc.server.commons.Mapper;
import com.spring.grpc.server.usuario.UsuarioDomain;

@Component
public class UsuarioDomainToEntityMapper implements Mapper<UsuarioDomain, UsuarioEntity> {
	@Override
	public UsuarioEntity to(UsuarioDomain source) {
		return UsuarioEntity.builder()
		.codigo(source.getCodigo())
		.email(source.getEmail())
		.senha(source.getSenha())
		.nome(source.getNome())
		.build();
	}
}
