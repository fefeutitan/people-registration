# people-registration
Cadastro de pessoas

### README

## Cadastro de Pessoas

Este projeto é uma aplicação web que permite o cadastro e gerenciamento de pessoas e seus respectivos endereços. A aplicação é construída utilizando Java Server Faces (JSF) com PrimeFaces para a interface do usuário, PostgreSQL como banco de dados relacional e Hibernate como implementação de JPA. A injeção de dependências é realizada via EJB. 

### Decisões Técnicas e Arquiteturais

1. **Java Server Faces (JSF):** Escolhido por sua integração com bibliotecas de componentes visuais como PrimeFaces, facilitando a criação de interfaces ricas para aplicações web.
2. **PrimeFaces:** Usado para melhorar a interface do usuário com componentes visuais modernos e responsivos.
3. **PostgreSQL:** Selecionado como banco de dados relacional por sua robustez, desempenho e suporte a funcionalidades avançadas.
4. **Hibernate:** Implementação de JPA que facilita o mapeamento objeto-relacional e abstrai a complexidade de interagir diretamente com o banco de dados.
5. **EJB:** Utilizado para injeção de dependências e para implementar a lógica de negócios de forma desacoplada e transacional.
6. **Docker:** Usado para facilitar a configuração e execução do banco de dados PostgreSQL.

### Justificativa para o Uso de Frameworks/Bibliotecas

- **PrimeFaces:** Simplifica a criação de interfaces de usuário com componentes prontos para uso e altamente configuráveis.
- **Hibernate:** Reduz a complexidade do mapeamento objeto-relacional e proporciona uma camada de abstração sobre o acesso a dados.
- **EJB:** Permite a criação de componentes modulares e transacionais, facilitando a manutenção e escalabilidade da aplicação.

### Instruções para Compilar e Executar o Projeto

#### Pré-requisitos

- JDK 8 ou superior
- Maven
- Docker e Docker Compose

#### Passo a Passo

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/your-repository/people-registration.git
   cd people-registration
   ```

2. **Configurar e iniciar o banco de dados PostgreSQL com Docker:**

   ```bash
   cd docker
   docker-compose up -d
   ```

3. **Compilar e empacotar a aplicação:**

   ```bash
   mvn clean package
   ```

4. **Implantar a aplicação em um servidor de aplicação compatível com Java EE (por exemplo, WildFly, Payara, TomEE):**

   - Copie o arquivo `people-registration.war` gerado na pasta `target` para o diretório de implantação do seu servidor de aplicação.

5. **Acesse a aplicação:**

   Abra um navegador web e acesse `http://localhost:8080/people-registration`.

### Instruções para Executar os Testes

1. **Executar testes unitários:**

   ```bash
   mvn test
   ```

2. **Testes de integração:**

   Testes de integração podem ser executados durante a fase de integração contínua ou manualmente configurando um ambiente de teste similar ao ambiente de produção.

### Notas Adicionais

- **Estrutura de Pastas:**
  - `src/main/java`: Contém o código fonte da aplicação.
  - `src/main/resources`: Contém recursos da aplicação, incluindo o arquivo `persistence.xml`.
  - `src/main/webapp`: Contém os arquivos da interface do usuário.
  - `docker`: Contém o `Dockerfile` e o `docker-compose.yml` para configuração do banco de dados.

- **Configuração do Banco de Dados:**
  - O banco de dados é configurado para rodar no contêiner Docker e pode ser acessado via `jdbc:postgresql://db:5432/people_db`.

- **Persistência:**
  - A configuração de persistência está definida no arquivo `persistence.xml`, que mapeia as entidades `Pessoa` e `Endereco` e define as propriedades de conexão com o banco de dados.

### Contato

Para dúvidas ou mais informações, entre em contato com [seu-email@exemplo.com].

---

Esta documentação foi criada para fornecer uma visão clara sobre a configuração e execução do projeto. Sinta-se à vontade para ajustar conforme necessário.
