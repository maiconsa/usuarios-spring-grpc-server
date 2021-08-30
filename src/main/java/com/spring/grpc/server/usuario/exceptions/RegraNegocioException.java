package com.spring.grpc.server.usuario.exceptions;

public class RegraNegocioException  extends RuntimeException{
	public RegraNegocioException(String mensagem) {
		super(mensagem);
	}
	
	public RegraNegocioException(String mensagem, Throwable causa) {
		super(mensagem,causa);
	}
}
