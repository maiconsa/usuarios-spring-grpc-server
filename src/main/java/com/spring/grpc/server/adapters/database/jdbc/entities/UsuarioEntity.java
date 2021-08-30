package com.spring.grpc.server.adapters.database.jdbc.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("usuarios")
public class UsuarioEntity {
	 @Id
	 private Long codigo;
	  private String nome;
	  private String email;
	  private String senha;
}
