package com.spring.grpc.server.usuario;

import java.util.Optional;

import com.spring.grpc.server.usuario.dto.DadosAtualizadoUsuarioDto;
import com.spring.grpc.server.usuario.exceptions.SenhaNaoCoincidentesException;
import com.spring.grpc.server.usuario.exceptions.UsuarioJaRegistradoException;
import com.spring.grpc.server.usuario.exceptions.UsuarioNaoEncontradoException;
import com.spring.grpc.server.usuario.ports.CadastraUsuarioServicePort;

public class CadastraUsuarioServiceImpl implements CadastraUsuarioServicePort {
	
	private UsuarioRepositoryPort usuarioRepository;
	
	public CadastraUsuarioServiceImpl(final UsuarioRepositoryPort usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UsuarioDomain cadastrar(UsuarioDomain usuario) {
		verificaCadastroDuplicado(usuario);
		return usuarioRepository.save(usuario);
	}

	@Override
	public UsuarioDomain atualizar(Long codigoUsuario, DadosAtualizadoUsuarioDto dadosAtualizados) {
		UsuarioDomain usuario = this.usuarioRepository.findById(codigoUsuario).orElseThrow(() -> new UsuarioNaoEncontradoException());
		
		if(!dadosAtualizados.getSenha().equals(dadosAtualizados.getConfirmarSenha())) {
			throw new SenhaNaoCoincidentesException();	
		}
		usuario.setEmail(dadosAtualizados.getEmail());
		usuario.setNome(dadosAtualizados.getNome());
		usuario.setSenha(dadosAtualizados.getSenha());
		
		return this.usuarioRepository.save(usuario);
	}
	
	private void verificaCadastroDuplicado(UsuarioDomain usuario) {
		boolean existeUsuarioComEmail = usuarioRepository.existsByEmail(usuario.getEmail());
		if(existeUsuarioComEmail) {
			throw new UsuarioJaRegistradoException("Já existe um usuário registrado com o e-mail informado");
		}
	}
	
}
