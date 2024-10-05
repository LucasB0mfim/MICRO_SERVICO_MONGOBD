# Microsserviços com Spring Boot

Este repositório contém dois microsserviços independentes desenvolvidos com Spring Boot: um para gerenciamento de clientes e outro para produtos. Além disso, existe um microsserviço de configuração que centraliza as configurações dos demais serviços.

## Descrição

Os serviços estão desenvolvidos com base em uma arquitetura de microsserviços, utilizando o Spring Boot, MongoDB para persistência de dados e OpenAPI (Swagger) para documentação das APIs.


- **ClienteService:** Serviço para gerenciamento de clientes, incluindo operações de CRUD.


- **ProdutoService:** Serviço para gerenciamento de produtos, também com operações de CRUD.


- **ConfigService:** Serviço que gerencia as configurações para os outros microsserviços usando Spring Cloud Config.


## Tecnologias Utilizadas

- Java 22


- Spring Boot 3.3.4


- Spring Data MongoDB


- Spring Cloud (para integração de microsserviços)


- Spring Cloud Config (para centralização de configurações)


- Spring Validation (para validação de dados de entrada)


- OpenAPI (Swagger) (para documentação da API)


- MongoDB (banco de dados NoSQL)


- Lombok (para reduzir a quantidade de código boilerplate)

## Endpoints Principais

### ClienteService

- GET `/cliente`: Retorna todos os clientes paginados.


- GET `/cliente/{id}`: Retorna um cliente pelo id.


- GET `/cliente/cpf/{cpf}`: Busca um cliente pelo CPF.


- POST `/cliente`: Cadastra um novo cliente.


- PUT `/cliente`: Atualiza as informações de um cliente existente.


- DELETE `/cliente/{id}`: Remove um cliente pelo seu id.

### ProdutoService

- GET `/produto`: Retorna todos os produtos paginados.


- GET `/produto/{id}`: Retorna um produto pelo id.


- POST `/produto`: Cadastra um novo produto.


- PUT `/produto`: Atualiza as informações de um produto existente.


- DELETE `/produto/{id}`: Remove um produto pelo seu id.

## Autor

**Lucas Bomfim** - Desenvolvedor do projeto.

## Contribuição

Sinta-se à vontade para contribuir com melhorias ou correções!

## Licença

Este projeto está licenciado sob a licença **Apache 2.0**.