# Seletivo SEPLAG

## Descrição do Candidato

- **Nome**: João Guilherme dos Santos Moreira

## Descrição do Projeto

Este projeto foi desenvolvido como parte de um processo seletivo e tem como objetivo implementar uma aplicação para gerenciar informações relacionadas a lotações, endereços e outros módulos. A aplicação foi construída utilizando o framework Spring Boot e segue boas práticas de desenvolvimento.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Gradle**: Ferramenta de build.
- **Docker**: Para containerização da aplicação.
- **MapStruct**: Para mapeamento de objetos DTO e entidades.
- **bruno**: Cliente de API para facilitar o teste das requisições.
- **PostgreSQL**: Banco de dados utilizado para persistência de dados.
- **Minio**: Para armazenamento de arquivos.

## Requisições com o Cliente de API bruno

No desenvolvimento do projeto, foi utilizado o cliente de API bruno, que pode ser baixado no site [usebruno](https://usebruno.com). Para realizar requisições de teste, faça o download do bruno e abra a pasta `bruno` dentro do cliente de API. As requisições estão organizadas em pastas, cada uma representando um módulo da aplicação.

Utilize a requisição de Login para obter o token JWT necessário para autenticar as demais requisições. O token deve ser colocado nas variáveis do environment `Base`. O token expira em 5 minutos, então é necessário realizar o login novamente após esse período.

## Autenticação

A aplicação utiliza autenticação baseada em tokens JWT (JSON Web Token). O fluxo de autenticação é o seguinte:

1. O usuário realiza login enviando suas credenciais para o endpoint de autenticação.
2. O servidor valida as credenciais e retorna um token JWT.
3. O token JWT é utilizado para autenticar as requisições subsequentes.

## Credenciais de Acesso

```json
{
  "usuario": "queridissimo",
  "senha": "123456"
}
```

## Como Executar o Projeto

1. Certifique-se de ter o Java 22 e o Gradle instalados.
2. Clone o repositório:
   ```bash
   git clone https://github.com/JGSMoreira/seletivo-seplag.git
   ```
3. Navegue até o diretório do projeto:
   ```bash
   cd seletivoSeplag
   ```
4. Execute o projeto:
   ```bash
   ./gradlew clean bootRun
   ```

## Docker

Para executar o projeto em um contêiner Docker, execute o seguinte comando na raiz do projeto:

```bash
docker-compose up
```

Isso irá iniciar o contêiner com a aplicação.

## Endpoints Disponíveis

Abaixo está a descrição de cada endpoint disponível, organizado por controller.

### Auth

- **POST /auth/login**

  - Descrição: Realiza a autenticação do usuário e retorna um token JWT.
  - Requisição: Enviar um JSON com `usuario` e `senha`.
  - Resposta: Um token JWT para autenticação.

- **POST /auth/refresh**
  - Descrição: Atualiza o token JWT.
  - Requisição: Enviar o token atual no cabeçalho `Authorization`.
  - Resposta: Um novo token JWT.

### Lotação

- **GET /lotacao**

  - Descrição: Lista todas as lotações com suporte a filtros e paginação.
  - Requisição: Parâmetros opcionais para filtros e paginação.
  - Resposta: Uma lista paginada de lotações.

- **POST /lotacao**

  - Descrição: Cria uma nova lotação.
  - Requisição: Enviar um JSON com os dados da lotação.
  - Resposta: A lotação criada.

- **PUT /lotacao/{id}**

  - Descrição: Atualiza uma lotação existente.
  - Requisição: Enviar um JSON com os dados atualizados.
  - Resposta: A lotação atualizada.

- **GET /lotacao/{id}**

  - Descrição: Busca uma lotação pelo ID.
  - Resposta: Os dados da lotação correspondente.

- **DELETE /lotacao/{id}**
  - Descrição: Remove uma lotação pelo ID.
  - Resposta: Sem conteúdo.

### Unidade

- **GET /unidade**

  - Descrição: Lista todas as unidades com suporte a filtros e paginação.
  - Requisição: Parâmetros opcionais para filtros e paginação.
  - Resposta: Uma lista paginada de unidades.

- **POST /unidade**

  - Descrição: Cria uma nova unidade.
  - Requisição: Enviar um JSON com os dados da unidade.
  - Resposta: A unidade criada.

- **PUT /unidade/{id}**

  - Descrição: Atualiza uma unidade existente.
  - Requisição: Enviar um JSON com os dados atualizados.
  - Resposta: A unidade atualizada.

- **GET /unidade/{id}**

  - Descrição: Busca uma unidade pelo ID.
  - Resposta: Os dados da unidade correspondente.

- **DELETE /unidade/{id}**
  - Descrição: Remove uma unidade pelo ID.
  - Resposta: Sem conteúdo.

### Servidor Efetivo

- **GET /servidor-efetivo**

  - Descrição: Lista todos os servidores efetivos com suporte a filtros e paginação.
  - Requisição: Parâmetros opcionais para filtros e paginação.
  - Resposta: Uma lista paginada de servidores efetivos.

- **POST /servidor-efetivo**

  - Descrição: Cria um novo servidor efetivo.
  - Requisição: Enviar um JSON com os dados do servidor.
  - Resposta: O servidor efetivo criado.

- **PUT /servidor-efetivo/{id}**

  - Descrição: Atualiza um servidor efetivo existente.
  - Requisição: Enviar um JSON com os dados atualizados.
  - Resposta: O servidor efetivo atualizado.

- **GET /servidor-efetivo/{id}**

  - Descrição: Busca um servidor efetivo pelo ID.
  - Resposta: Os dados do servidor correspondente.

- **DELETE /servidor-efetivo/{id}**
  - Descrição: Remove um servidor efetivo pelo ID.
  - Resposta: Sem conteúdo.

### Servidor Temporário

- **GET /servidor-temporario**

  - Descrição: Lista todos os servidores temporários com suporte a filtros e paginação.
  - Requisição: Parâmetros opcionais para filtros e paginação.
  - Resposta: Uma lista paginada de servidores temporários.

- **POST /servidor-temporario**

  - Descrição: Cria um novo servidor temporário.
  - Requisição: Enviar um JSON com os dados do servidor.
  - Resposta: O servidor temporário criado.

- **PUT /servidor-temporario/{id}**

  - Descrição: Atualiza um servidor temporário existente.
  - Requisição: Enviar um JSON com os dados atualizados.
  - Resposta: O servidor temporário atualizado.

- **GET /servidor-temporario/{id}**

  - Descrição: Busca um servidor temporário pelo ID.
  - Resposta: Os dados do servidor correspondente.

- **DELETE /servidor-temporario/{id}**
  - Descrição: Remove um servidor temporário pelo ID.
  - Resposta: Sem conteúdo.

### Cidade

- **GET /cidade**

  - Descrição: Lista todas as cidades com suporte a filtros e paginação.
  - Requisição: Parâmetros opcionais para filtros e paginação.
  - Resposta: Uma lista paginada de cidades.

- **POST /cidade**

  - Descrição: Cria uma nova cidade.
  - Requisição: Enviar um JSON com os dados da cidade.
  - Resposta: A cidade criada.

- **PUT /cidade/{id}**

  - Descrição: Atualiza uma cidade existente.
  - Requisição: Enviar um JSON com os dados atualizados.
  - Resposta: A cidade atualizada.

- **GET /cidade/{id}**

  - Descrição: Busca uma cidade pelo ID.
  - Resposta: Os dados da cidade correspondente.

- **DELETE /cidade/{id}**
  - Descrição: Remove uma cidade pelo ID.
  - Resposta: Sem conteúdo.

## Exemplos de JSON para os Endpoints

Abaixo estão exemplos de JSON para os endpoints disponíveis, baseados nos DTOs utilizados.

### Auth

- **POST /auth/login**
  - Requisição:
    ```json
    {
      "usuario": "queridissimo",
      "senha": "123456"
    }
    ```
  - Resposta:
    ```json
    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
      "expiracao": "2025-04-09T12:00:00Z"
    }
    ```

### Lotação

- **POST /lotacao**
  - Requisição:
    ```json
    {
      "dataLocacao": "2025-04-01",
      "dataRemocao": null,
      "pessoaId": 1,
      "portaria": "Portaria 123",
      "unidadeId": 2
    }
    ```

### Unidade

- **POST /unidade**
  - Requisição:
    ```json
    {
      "nome": "Unidade Central",
      "enderecos": [
        {
          "logradouro": "Rua Principal",
          "numero": "123",
          "bairro": "Centro",
          "cidade": 1,
          "tipoLogradouro": "Rua"
        }
      ]
    }
    ```

### Servidor Efetivo

- **POST /servidor-efetivo**
  - Requisição:
    ```json
    {
      "nome": "Maria Oliveira",
      "sexo": "Feminino",
      "dataNascimento": "1990-01-01",
      "mae": "Ana Oliveira",
      "pai": "Carlos Oliveira",
      "matricula": "123456",
      "lotacoes": [
        {
          "dataLocacao": "2025-04-01",
          "dataRemocao": null,
          "portaria": "Portaria 123",
          "unidade": 2
        }
      ],
      "enderecos": [
        {
          "logradouro": "Rua das Flores",
          "numero": "456",
          "bairro": "Jardim",
          "cidade": 1,
          "tipoLogradouro": "Rua"
        }
      ]
    }
    ```

### Servidor Temporário

- **POST /servidor-temporario**
  - Requisição:
    ```json
    {
      "nome": "Maria Oliveira",
      "sexo": "Feminino",
      "dataNascimento": "1990-01-01",
      "mae": "Ana Oliveira",
      "pai": "Carlos Oliveira",
      "dataAdmissao": "2025-04-01",
      "dataDemissao": null,
      "lotacoes": [
        {
          "dataLocacao": "2025-04-01",
          "portaria": "Portaria 123",
          "unidade": 2
        }
      ],
      "enderecos": [
        {
          "logradouro": "Rua das Flores",
          "numero": "456",
          "bairro": "Jardim",
          "cidade": 1,
          "tipoLogradouro": "Rua"
        }
      ]
    }
    ```

### Cidade

- **POST /cidade**
  - Requisição:
    ```json
    {
      "nome": "Belo Horizonte",
      "estado": "MG"
    }
    ```
