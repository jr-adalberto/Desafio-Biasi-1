# API de Cadastro de Clientes

Este projeto foi desenvolvido como parte de um desafio proposto por um amigo mais experiente na área. A API permite realizar operações básicas de cadastro de clientes, incluindo criação, leitura, atualização e exclusão de registros, usando um banco de dados PostgreSQL. Também foram implementados tratamentos de erros e testes utilizando o Postman.

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Postman](https://www.postman.com/downloads/)
- Uma IDE de sua preferência, como IntelliJ IDEA ou Eclipse

## Configuração do Banco de Dados

1. Instale o PostgreSQL em seu sistema, se ainda não estiver instalado.
2. Crie um banco de dados no PostgreSQL para usar com a API.
3. Configure as credenciais do banco de dados no arquivo `application.properties`.

## Executando a API

1. Clone este repositório em sua máquina local.
2. Importe o projeto em sua IDE.
3. Execute a aplicação.

A API estará disponível em http://localhost:8080.

## Endpoints

- `GET /clientes`: Retorna uma lista de todos os clientes cadastrados.
- `GET /clientes/{id}`: Retorna os detalhes de um cliente específico.
- `POST /clientes`: Cria um novo cliente.
- `PUT /clientes/{id}`: Atualiza os dados de um cliente existente.
- `DELETE /clientes/{id}`: Exclui um cliente existente.

## Testando a API

Você pode usar o Postman para testar os endpoints da API. Importe a coleção de requisições disponível no diretório `postman` e execute as requisições conforme necessário.
