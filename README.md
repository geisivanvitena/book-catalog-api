# Book Catalog API

API REST desenvolvida para gerenciamento de um catálogo de livros, permitindo realizar operações de cadastro, consulta, atualização e exclusão de livros.

## Tecnologias

- Java 17
- Spring Boot
- Gradle
- PostgreSQL
- JPA / Hibernate
- Lombok

## Funcionalidades

- Cadastro de livros
- Consulta de todos os livros
- Consulta de livro por ID
- Atualização de livros
- Exclusão de livros

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/api/v1/books` | Cadastrar livro |
| GET | `/api/v1/books` | Listar livros |
| GET | `/api/v1/books/{id}` | Buscar livro por ID |
| PUT | `/api/v1/books/{id}` | Atualizar livro |
| DELETE | `/api/v1/books/{id}` | Excluir livro |

## Exemplo de cadastro

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "category": "Engenharia de Software",
  "publicationYear": 2008
}
```

## Como executar

Pré-requisitos

Antes de executar o projeto, certifique-se de que possui instalado:

- Java 17
- PostgreSQL
- Git

1. Clone o repositório

```bash
git clone https://github.com/geisivan/book-catalog-api.git
```

2. Acesse o diretório do projeto

```bash
cd book-catalog-api
```

3. Configure o banco de dados

Crie um banco de dados PostgreSQL e configure as informações de conexão no arquivo:

`application.properties` 

Configure a URL, usuário e senha de acordo com o seu ambiente.

4. Execute a aplicação 

No Windows

```bash
./gradlew.bat bootRun
``` 
5. Acesse a API

Após iniciar a aplicação, a API estará disponível em:

`http://localhost:8080`