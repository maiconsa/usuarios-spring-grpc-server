package com.spring.grpc.server.adapters.grpc;

import com.spring.grpc.server.usuario.exceptions.RegraNegocioException;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class ExceptionHandlerAdvice {
	  @GrpcExceptionHandler(Exception.class)
	    public Status handleException(Exception e) {
	        return Status.INTERNAL.withCause(e).withDescription("Houve um erro interno ao tentar processar a requisição");
	    }
	  
	  @GrpcExceptionHandler(RegraNegocioException.class)
	  public Status handleRegraNegocioException(RegraNegocioException e) {
		  return Status.INVALID_ARGUMENT.withCause(e).withDescription(e.getMessage());
	  }

}
