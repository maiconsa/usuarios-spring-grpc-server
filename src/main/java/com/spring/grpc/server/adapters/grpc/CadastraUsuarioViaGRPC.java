package com.spring.grpc.server.adapters.grpc;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.grpc.server.commons.Mapper;
import com.spring.grpc.server.usuario.UsuarioDomain;
import com.spring.grpc.server.usuario.dto.DadosAtualizadoUsuarioDto;
import com.spring.grpc.server.usuario.ports.CadastraUsuarioServicePort;
import com.usuarios.grpc.def.cadastro.AtualizaUsuarioRequest;
import com.usuarios.grpc.def.cadastro.CadastraUsuarioRequest;
import com.usuarios.grpc.def.cadastro.CadastraUsuarioServiceGrpc;
import com.usuarios.grpc.def.cadastro.UsuarioAtualizadoReply;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
@GrpcService
public class CadastraUsuarioViaGRPC extends CadastraUsuarioServiceGrpc.CadastraUsuarioServiceImplBase {

	@Autowired
	private CadastraUsuarioServicePort cadastraUsuarioService;

	@Autowired
	private Mapper<CadastraUsuarioRequest, UsuarioDomain> cadastroUsuarioRequestToDomain;
	
	@Autowired
	private Mapper<UsuarioDomain, UsuarioAtualizadoReply> usuarioDomainToReply;
	
	@Autowired
	private Mapper<AtualizaUsuarioRequest,DadosAtualizadoUsuarioDto> atualizaRequestToDto;
	
	@Override
	public void cadastraUsuario(CadastraUsuarioRequest request, StreamObserver<UsuarioAtualizadoReply> responseObserver) {
			UsuarioDomain usuarioCadastrado =cadastroUsuarioRequestToDomain.to(request);
			usuarioCadastrado = cadastraUsuarioService.cadastrar(usuarioCadastrado);
			UsuarioAtualizadoReply response = usuarioDomainToReply.to(usuarioCadastrado);
			responseObserver.onNext(response);
			responseObserver.onCompleted();
	}
	
	@Override
	public void atualizaUsuario(AtualizaUsuarioRequest request,
			StreamObserver<UsuarioAtualizadoReply> responseObserver) {	
		UsuarioDomain usuarioAtualizado = this.cadastraUsuarioService.atualizar(Long.parseLong(request.getCodigo()), atualizaRequestToDto.to(request));	
		UsuarioAtualizadoReply response = usuarioDomainToReply.to(usuarioAtualizado);
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
