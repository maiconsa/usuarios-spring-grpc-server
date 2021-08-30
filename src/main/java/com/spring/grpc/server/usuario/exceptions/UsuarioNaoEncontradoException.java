package com.spring.grpc.server.usuario.exceptions;

public class UsuarioNaoEncontradoException extends RegraNegocioException {
	private final static String MENSAGEM = "Usuário não encontrado para o código informado!!!";
	public UsuarioNaoEncontradoException() {
		super(MENSAGEM);
	}
}
