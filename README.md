# People Registration

Aplicacao web para cadastro de pessoas com JSF, PrimeFaces, JPA/Hibernate e PostgreSQL.

## Requisitos

- JDK 8+
- Maven
- Docker e Docker Compose
- Servidor Java EE compativel com JSF, EJB e JPA, como WildFly, Payara ou TomEE

## Banco de dados

O projeto inclui uma configuracao simples do PostgreSQL em `src/main/docker/docker-compose.yml`.

```bash
cd src/main/docker
docker-compose up -d
```

Por padrao, a aplicacao usa:

- Banco: `people_db`
- Usuario: `postgres`
- Senha: `root`
- URL JDBC: `jdbc:postgresql://localhost:5432/people_db`

## Build

```bash
mvn clean package
```

O artefato gerado fica em `target/people-registration.war`.

## Deploy

Publique o arquivo WAR em um servidor de aplicacao compativel com Java EE.

Depois do deploy, acesse:

```text
http://localhost:8080/people-registration
```

## Estrutura

- `src/main/java`: codigo-fonte Java
- `src/main/resources/META-INF/persistence.xml`: configuracao JPA
- `src/main/webapp`: paginas JSF e descritores web
- `src/main/docker`: arquivos de suporte ao PostgreSQL local

## Observacoes

- O projeto foi simplificado para o fluxo web; a classe standalone `MainApp` foi removida.
- O repositorio `PessoaRepository` agora expoe apenas os metodos usados pela aplicacao.
- Se o servidor de aplicacao exigir datasource JTA gerenciado, adapte o `persistence.xml` para usar o datasource do servidor.
