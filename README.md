# Spring Boot API Demo

## 📋 Descrição

Este projeto é uma API REST desenvolvida com Spring Boot, simulando uma rede social simplificada com gerenciamento de usuários e posts. A aplicação adota uma arquitetura em camadas, separando responsabilidades em **controladores**, **serviços**, **repositórios**, **DTOs**, **exceções** e **configurações**, promovendo boa organização e manutenibilidade.

É uma base excelente para aprender a desenvolver APIs com Java, Spring Boot e MongoDB.

---

## 🛠 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data MongoDB
- Maven
- MongoDB (banco de dados NoSQL)

---

## 🧱 Arquitetura da Aplicação

O projeto segue a arquitetura típica de aplicações Spring:

- **Camada `domain/`**: contém as entidades de domínio (como `User` e `Post`) que representam os dados do negócio.
- **Camada `dto/`**: contém os Data Transfer Objects usados para trafegar dados entre a API e os clientes de forma controlada.
- **Camada `repository/`**: define interfaces que fazem a ponte com o banco de dados MongoDB.
- **Camada `services/`**: encapsula a lógica de negócio da aplicação, intermediando o acesso aos dados.
- **Camada `resources/` (controllers)**: define os endpoints REST da API e responde às requisições HTTP.
- **Camada `exception/` e `config/`**: cuida do tratamento de exceções e da configuração inicial da aplicação (ex: dados de teste).

---

## 📁 Estrutura do Projeto

```
src/main/java/com/example/demo/
├── config/
│   └── Instantiation.java          # Popula o banco com dados iniciais ao iniciar a aplicação
├── domain/
│   ├── User.java                   # Entidade que representa um usuário
│   └── Post.java                   # Entidade que representa um post feito por um usuário
├── dto/
│   ├── UserDTO.java                # Versão simplificada da entidade User para transferir dados
│   ├── AuthorDTO.java              # Usado em posts para representar o autor (nome + id)
│   └── CommentDTO.java             # Comentários embutidos nos posts
├── repository/
│   ├── UserRepository.java         # Interface para operações com usuários no MongoDB
│   └── PostRepository.java         # Interface para operações com posts no MongoDB
├── resources/
│   ├── UserResource.java           # Controlador REST para endpoints de usuário
│   ├── PostResource.java           # Controlador REST para endpoints de post
│   ├── exception/
│   │   ├── ResourceExceptionHandler.java  # Manipulador global de exceções
│   │   └── StandardError.java             # Modelo de erro retornado pela API
│   └── util/
│       └── URL.java               # Utilitário para decodificação de parâmetros de URL
├── services/
│   ├── UserService.java           # Lógica de negócio para usuários
│   ├── PostService.java           # Lógica de negócio para posts
│   └── exception/
│       └── ObjectNotFoundException.java   # Exceção lançada quando recurso não é encontrado
```

---

## 🚀 Como Executar

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/fernandoMaia0/springboot.git
   cd springboot
   ```

2. **Configure o MongoDB:**

   Certifique-se de que o MongoDB esteja instalado e rodando na porta padrão (`27017`).

3. **Execute a aplicação:**

   ```bash
   ./mvnw spring-boot:run
   ```

   A aplicação ficará disponível em:  
   `http://localhost:8080`

---

## 📌 Endpoints Principais

### Usuários

- `GET /users` – Lista todos os usuários  
- `GET /users/{id}` – Detalha um usuário específico  
- `POST /users` – Cria um novo usuário  
- `PUT /users/{id}` – Atualiza um usuário  
- `DELETE /users/{id}` – Remove um usuário  

### Posts

- `GET /posts` – Lista todos os posts  
- `GET /posts/{id}` – Detalha um post específico  
- `POST /posts` – Cria um novo post  
- `GET /posts/{id}/comments` – Lista comentários de um post  

---

## 🧪 Testes

Testes básicos estão localizados em:

```
src/test/java/com/example/demo/DemoApplicationTests.java
```

Para executá-los:

```bash
./mvnw test
```
