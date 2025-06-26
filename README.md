# 🗂️ TaskFlow

> API REST de gerenciamento de usuários, projetos e tarefas, desenvolvida com Spring Boot, seguindo boas práticas de organização e arquitetura (DDD). Ideal para controle de produtividade e fluxo de trabalho.

---

## 🚀 Tecnologias

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL (ou H2 para testes)
- Lombok
- Git & GitHub

---

## 📦 Estrutura de Pastas (DDD)

```bash
src/main/java/com/gustavo/taskflow/
├── application      # Regras de negócio (services)
├── controller       # Endpoints da API
├── domain
│   ├── model        # Entidades (User, Task, Project)
│   └── repository   # Interfaces dos repositórios
├── exception        # (futuramente para Exception Handling)
└── TaskflowApplication.java
