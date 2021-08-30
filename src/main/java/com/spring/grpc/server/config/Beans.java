package com.spring.grpc.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.grpc.server.usuario.CadastraUsuarioServiceImpl;
import com.spring.grpc.server.usuario.UsuarioRepositoryPort;

@Configuration
public class Beans {
		
	@Bean
	public CadastraUsuarioServiceImpl cadastraUsuarioServiceImpl(UsuarioRepositoryPort usuarioRepository) {
		return new CadastraUsuarioServiceImpl(usuarioRepository);
	}
}
