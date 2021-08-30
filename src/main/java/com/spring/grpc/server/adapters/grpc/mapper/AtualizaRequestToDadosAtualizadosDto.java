package com.spring.grpc.server.adapters.grpc.mapper;

import org.springframework.stereotype.Component;

import com.spring.grpc.server.commons.Mapper;
import com.spring.grpc.server.usuario.dto.DadosAtualizadoUsuarioDto;
import com.usuarios.grpc.def.cadastro.AtualizaUsuarioRequest;

@Component
public class AtualizaRequestToDadosAtualizadosDto implements Mapper<AtualizaUsuarioRequest, DadosAtualizadoUsuarioDto> {
	@Override
	public DadosAtualizadoUsuarioDto to(AtualizaUsuarioRequest source) {
		
		return DadosAtualizadoUsuarioDto.builder().nome(source.getNome())
				.email(source.getEmail())
				.senha(source.getSenha())
				.confirmarSenha(source.getConfirmaSenha())
				.build();
	}
}
