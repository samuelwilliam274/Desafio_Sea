# Desafio Backend - SEA Tecnologia (versão melhorada)

Projeto Spring Boot 3 - API simples para gerenciamento de clientes (CRUD) com validações e tratamento de exceções.

## Tecnologias
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 (banco em memória)
- Spring Security (in-memory users)
- Lombok
- Validation (Jakarta Validation)

## Usuários de teste (in-memory)
- admin / 123qwe!@# (role: ADMIN)
- user / 123qwe@123 (role: USER)

> Observação: por facilidade e para o avaliador testar a API sem autenticação, as rotas `/clientes/**` estão **permitidas** no SecurityConfig. Se quiser, altero para exigir autenticação (ADMIN) nas operações de escrita.

## Endpoints principais
- `GET /clientes` → lista todos os clientes
- `GET /clientes/{id}` → busca por id
- `POST /clientes` → cria novo cliente (validações)
- `PUT /clientes/{id}` → atualiza cliente
- `DELETE /clientes/{id}` → deleta cliente

## Regras de validação (simples)
- `nome`: obrigatório, entre 3 e 100 caracteres
- `cpf`: obrigatório, exatamente 11 caracteres (sem máscara)

## Rodando localmente (IntelliJ)
1. Abra o projeto no IntelliJ (pasta raiz com `pom.xml`).
2. Aguarde o Maven baixar as dependências.
3. Execute a classe `com.desafio.backend.BackendApplication`.
4. Acesse `http://localhost:8080/clientes`.
5. Console H2: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)

## Testes rápidos (curl)
Criar cliente:
```bash
curl -X POST http://localhost:8080/clientes -H 'Content-Type: application/json' -d '{"nome":"Samuel William","cpf":"12345678900"}'
```

Listar clientes:
```bash
curl http://localhost:8080/clientes
```

## Observações finais
- O projeto está preparado para evoluir: adicionar DTOs adicionais, integração com ViaCEP, mascaramento de CPF, autenticação por JWT, testes unitários e dockerização.
- Posso subir este projeto para um repositório GitHub com commits descritivos, se quiser.
