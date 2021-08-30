package com.spring.grpc.server.usuario.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DadosAtualizadoUsuarioDto {
	private String nome;
	private String email;
	private String senha;
	private String confirmarSenha;
}
