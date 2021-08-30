package com.spring.grpc.server.adapters.grpc.mapper;

import org.springframework.stereotype.Component;

import com.spring.grpc.server.commons.Mapper;
import com.spring.grpc.server.usuario.UsuarioDomain;
import com.usuarios.grpc.def.cadastro.UsuarioAtualizadoReply;

@Component
public class UsuarioDomainToReply implements Mapper<UsuarioDomain, UsuarioAtualizadoReply> {

	@Override
	public UsuarioAtualizadoReply to(UsuarioDomain source) {
		return UsuarioAtualizadoReply.newBuilder()
				.setCodigo(source.getCodigo().toString())
				.setEmail(source.getEmail())
				.setNome(source.getNome())
				.build();
	}

}
