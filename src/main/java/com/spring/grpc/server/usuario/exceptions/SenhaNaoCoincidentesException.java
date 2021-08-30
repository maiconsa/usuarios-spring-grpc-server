package com.spring.grpc.server.usuario.exceptions;

public class SenhaNaoCoincidentesException extends RegraNegocioException {
	private static final String MENSAGEM  = "As senhas informadas são diferentes";
	public SenhaNaoCoincidentesException() {
		super(MENSAGEM);
	}
}
