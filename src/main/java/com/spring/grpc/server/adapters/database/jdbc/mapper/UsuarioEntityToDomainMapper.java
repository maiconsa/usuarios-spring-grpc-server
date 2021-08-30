package com.spring.grpc.server.adapters.database.jdbc.mapper;

import org.springframework.stereotype.Component;

import com.spring.grpc.server.adapters.database.jdbc.entities.UsuarioEntity;
import com.spring.grpc.server.commons.Mapper;
import com.spring.grpc.server.usuario.UsuarioDomain;

@Component
public class UsuarioEntityToDomainMapper implements Mapper<UsuarioEntity, UsuarioDomain> {
	@Override
	public UsuarioDomain to(UsuarioEntity source) {
		return UsuarioDomain.builder()
		.codigo(source.getCodigo())
		.email(source.getEmail())
		.senha(source.getSenha())
		.nome(source.getNome())
		.build();
	}
}
