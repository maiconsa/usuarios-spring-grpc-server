package com.spring.grpc.server.usuario.exceptions;

public class UsuarioJaRegistradoException extends RegraNegocioException {
	public UsuarioJaRegistradoException(String mensagem) {
			super(mensagem);
	}
	
	
}
