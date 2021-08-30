package com.spring.grpc.server.adapters.database.jdbc;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.grpc.server.adapters.database.jdbc.entities.UsuarioEntity;
import com.spring.grpc.server.commons.Mapper;
import com.spring.grpc.server.usuario.UsuarioDomain;
import com.spring.grpc.server.usuario.UsuarioRepositoryPort;

@Component
@Primary
public class JdbcUsuarioRepository implements UsuarioRepositoryPort {
	
	private UsuarioRepository usuarioRepository;
	
	private Mapper<UsuarioEntity, UsuarioDomain> mapperToDomain;
	private Mapper<UsuarioDomain, UsuarioEntity> mapperToEntity;
	
	 public JdbcUsuarioRepository(  final UsuarioRepository usuarioRepository ,  final Mapper<UsuarioEntity, UsuarioDomain> mapperToDomain,
			 final Mapper<UsuarioDomain, UsuarioEntity> mapperToEntity 
			 ) {
		this.usuarioRepository = usuarioRepository;
		this.mapperToDomain = mapperToDomain;
		this.mapperToEntity = mapperToEntity;
	}
	
	@Override
	public UsuarioDomain save(UsuarioDomain usuario) {
		UsuarioEntity entidade = this.mapperToEntity.to(usuario);
		entidade =  usuarioRepository.save(entidade);
		return this.mapperToDomain.to(entidade);
	}

	@Override
	public boolean existsByEmail(String email) {
		return this.usuarioRepository.existsByEmail(email);
	}
	
	@Override
	public Optional<UsuarioDomain> findById(Long codigo) {
		Optional<UsuarioEntity> buscaEntidade =  this.usuarioRepository.findById(codigo);
		if(buscaEntidade.isPresent()) {
			return Optional.of(this.mapperToDomain.to(buscaEntidade.get()));
		}else {
			return Optional.empty();
		}
	}
}
