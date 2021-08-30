package com.spring.grpc.server.adapters.grpc.mapper;

import org.springframework.stereotype.Component;

import com.spring.grpc.server.commons.Mapper;
import com.spring.grpc.server.usuario.UsuarioDomain;
import com.usuarios.grpc.def.cadastro.CadastraUsuarioRequest;

@Component
public class UsuarioRequestToDomain implements Mapper<CadastraUsuarioRequest, UsuarioDomain> {

	@Override
	public UsuarioDomain to(CadastraUsuarioRequest source) {
	return UsuarioDomain.builder().nome(source.getNome()).senha(source.getSenha())
			.email(source.getEmail()).build();
	}

}
