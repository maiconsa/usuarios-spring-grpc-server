# usuarios-spring-grpc-server
Implementação de um microsserviço  de cadastro de usuário utilizando gRPC, arquitetura Hexagonal, SOLID e Clean Code. As definições dos serviço de gRPC estão presentes no  [usuario-grpc-interface](https://github.com/maiconsa/usuarios-grpc-interface).

Para a persistencia foi configurado um banco em memória H2 utilizando Spring Data JDBC como interface de persistencia dos dados.

## Pré-requisitos

 - Java 15
 - Projeto [usuario-grpc-interface](https://github.com/maiconsa/usuarios-grpc-interface) compilado 



## Execução de testes com grpcurl

Para executar os testes dos serviços gRPC é necessário utilizar o [grpcul](https://github.com/fullstorydev/grpcurl)
Para cadastrar um novo usuário execute: 

```bash
grpcurl --plaintext -d '{"nome": "Dummy name" , "email" : "dummy@dummy.com", "senha" : "admin"}' localhost:9090 com.usuarios.def.CadastraUsuarioService/CadastraUsuario
```
Para atualizar um usuário existente:

```bash
grpcurl --plaintext -d '{"codigo" : "1","nome": "Dummy name atualizado" , "email" : "dummy-updated@dummy.com", "senha" : "admin" , "confirmaSenha" : "admin"}' localhost:9090 com.usuarios.def.CadastraUsuarioService/AtualizaUsuario
```