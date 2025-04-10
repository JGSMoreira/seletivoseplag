# Seletivo SEPLAG

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

