# Desafio: API de Tarefas

API REST desenvolvida com Java e Spring Boot como solução para o desafio proposto pelo professor **Mateus Leandro Ferreira**, no YouTube.

Projeto voltado à prática de criação de endpoints, persistência de dados e consultas com filtros.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA e Hibernate
- H2 Database

## Funcionalidades

- Cadastrar tarefas com título, descrição, responsável, data de entrega e situação de conclusão.
- Listar tarefas e filtrar por responsável.
- Buscar tarefas pela data de entrega.
- Consultar tarefas pendentes, com filtro opcional por responsável.

## Endpoints

| Método | Rota | Descrição |
| --- | --- | --- |
| POST | `/tarefas` | Cadastrar tarefa |
| GET | `/tarefas` | Listar todas as tarefas |
| GET | `/tarefas?responsavel=Pedro` | Filtrar por responsável |
| GET | `/tarefas/data?data=2026-09-06` | Buscar por data de entrega |
| GET | `/tarefas/pendentes` | Listar tarefas pendentes |
| GET | `/tarefas/pendentes?responsavel=Pedro` | Filtrar pendentes por responsável |

## Como executar

1. Clone o repositório.
2. Abra o projeto na IDE e carregue as dependências.
3. Execute a classe `EstagioApplication`.
4. Acesse a API em `http://localhost:8080/tarefas`.

O banco H2 funciona em memória, portanto os dados não são mantidos após encerrar a aplicação.

## Créditos

Desafio proposto pelo professor **Mateus Leandro Ferreira**.

Implementação desenvolvida por **Pedro Henrique dos Santos Silva** para estudo e prática de desenvolvimento backend.
