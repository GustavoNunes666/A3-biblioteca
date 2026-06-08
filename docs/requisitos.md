# Requisitos do Sistema

## O problema

Quem já trabalhou ou estagiou em uma biblioteca sabe como é: o responsável pelos empréstimos anota num papel ou numa planilha, e quando chega a hora de cobrar a devolução, não lembra mais quem pegou, qual livro foi, por quanto tempo, nem quando deveria ter voltado. Vira uma bagunça.

Esse sistema nasceu pra resolver exatamente isso. Nada de anotar em papel. Nada de ficar procurando em planilha. O sistema controla tudo automaticamente.

---

## Atores

| Ator | Descrição |
|---|---|
| **Bibliotecário** | Cadastra livros e usuários, registra empréstimos e devoluções |
| **Leitor** | Usuário que realiza empréstimos e devoluções de livros |

---

## User Stories

### US01 — Cadastrar livro
**Como** bibliotecário,  
**quero** cadastrar um livro no sistema,  
**para que** ele fique disponível para empréstimo sem precisar anotar em papel.

**Critérios de aceitação:**
- O sistema aceita título, autor e ISBN
- O livro já fica marcado como disponível automaticamente
- O sistema retorna os dados do livro cadastrado

---

### US02 — Listar livros
**Como** bibliotecário,  
**quero** ver todos os livros cadastrados,  
**para que** eu saiba de cara quais estão disponíveis e quais estão emprestados.

**Critérios de aceitação:**
- O sistema retorna todos os livros
- Cada livro mostra se está disponível ou emprestado

---

### US03 — Cadastrar usuário
**Como** bibliotecário,  
**quero** cadastrar quem pode pegar livros emprestados,  
**para que** eu sempre saiba com quem está cada livro.

**Critérios de aceitação:**
- O sistema aceita nome e email
- O sistema retorna os dados do usuário cadastrado

---

### US04 — Realizar empréstimo
**Como** bibliotecário,  
**quero** registrar o empréstimo de um livro,  
**para que** o sistema já calcule automaticamente quando ele deve voltar, sem eu precisar fazer isso na cabeça.

**Critérios de aceitação:**
- O sistema verifica se o livro está disponível antes de registrar
- Se o livro já estiver emprestado, o sistema avisa com erro
- O prazo de devolução é calculado automaticamente (7 dias)
- O livro fica marcado como indisponível após o empréstimo

---

### US05 — Registrar devolução
**Como** bibliotecário,  
**quero** registrar quando um livro é devolvido,  
**para que** ele volte a ficar disponível para outros leitores automaticamente.

**Critérios de aceitação:**
- O sistema marca o empréstimo como devolvido
- O livro volta a aparecer como disponível

---

### US06 — Ver empréstimos em aberto
**Como** bibliotecário,  
**quero** ver tudo que ainda não foi devolvido,  
**para que** eu saiba exatamente o que cobrar e de quem, sem depender da minha memória.

**Critérios de aceitação:**
- O sistema retorna apenas os empréstimos ainda não devolvidos
- Cada registro mostra o livro, o usuário e a data prevista de devolução

---

### US07 — Ver histórico de um usuário
**Como** bibliotecário,  
**quero** ver o histórico de empréstimos de um leitor específico,  
**para que** eu tenha o registro completo do que ele já pegou, devolveu ou ainda tem em mãos.

**Critérios de aceitação:**
- O sistema retorna todos os empréstimos do usuário informado
- O histórico inclui tanto os já devolvidos quanto os em aberto

---

## Backlog Priorizado

| Prioridade | User Story | Status |
|---|---|---|
| Alta | US04 — Realizar empréstimo | ✅ Implementado |
| Alta | US05 — Registrar devolução | ✅ Implementado |
| Alta | US01 — Cadastrar livro | ✅ Implementado |
| Alta | US03 — Cadastrar usuário | ✅ Implementado |
| Média | US06 — Ver empréstimos em aberto | ✅ Implementado |
| Média | US02 — Listar livros | ✅ Implementado |
| Baixa | US07 — Ver histórico de usuário | ✅ Implementado |
