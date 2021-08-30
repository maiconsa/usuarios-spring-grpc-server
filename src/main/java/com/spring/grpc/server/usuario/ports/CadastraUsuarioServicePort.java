package com.spring.grpc.server.usuario.ports;

import com.spring.grpc.server.usuario.UsuarioDomain;
import com.spring.grpc.server.usuario.dto.DadosAtualizadoUsuarioDto;

public interface CadastraUsuarioServicePort {
	UsuarioDomain cadastrar(UsuarioDomain usuario);
	UsuarioDomain atualizar(Long codigoUsuario, DadosAtualizadoUsuarioDto dadosAtualizados);
}
