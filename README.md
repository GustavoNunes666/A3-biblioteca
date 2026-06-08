# A3 - Sistema de Controle de Empréstimos de Biblioteca

Trabalho da disciplina de **Modelos, Métodos e Técnicas de Engenharia de Software** — Ciências da Computação, UniBH.

A ideia surgiu do meu gosto por livros. Bibliotecas que ainda controlam empréstimos em papel ou planilha perdem histórico, não sabem quais livros estão disponíveis e não conseguem rastrear atrasos. Decidi resolver isso com uma API simples e funcional.

O sistema permite cadastrar livros e usuários, registrar empréstimos e devoluções, e consultar o que está em aberto — tudo via API REST.

## Tecnologias

- Java 17
- Spring Boot 3.5
- Spring Data JPA
- H2 Database
- JUnit 5 + Mockito

## Como rodar

```bash
git clone https://github.com/GustavoNunes666/A3-biblioteca.git
cd A3-biblioteca
.\mvnw spring-boot:run
```

A API sobe em `http://localhost:8080`

## Endpoints principais

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/livros` | Cadastrar livro |
| GET | `/livros` | Listar livros |
| POST | `/usuarios` | Cadastrar usuário |
| POST | `/emprestimos?livroId=1&usuarioId=1` | Realizar empréstimo |
| PUT | `/emprestimos/{id}/devolver` | Devolver livro |
| GET | `/emprestimos/abertos` | Listar empréstimos em aberto |

## Testes

```bash
.\mvnw test
```

## Aluno

**Gustavo Nunes Cunha** — RA: 123113556
