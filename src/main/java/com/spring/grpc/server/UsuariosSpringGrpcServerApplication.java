package com.spring.grpc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories()
public class UsuariosSpringGrpcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosSpringGrpcServerApplication.class, args);
	}

}