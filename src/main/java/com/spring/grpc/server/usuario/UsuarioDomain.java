package com.spring.grpc.server.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDomain {
	private Long codigo;
	private String nome;
	private String email;
	private String senha;
}
