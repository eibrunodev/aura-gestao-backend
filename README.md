# 🌟 Aura Gestão

> **Sistema de gestão desenvolvido em Java e Spring Boot como projeto prático de estudo, evolução técnica e construção de portfólio Backend.**

O **Aura Gestão** é um projeto pessoal desenvolvido com o objetivo de aprofundar conhecimentos em **desenvolvimento Backend com Java**, aplicando conceitos de arquitetura, persistência de dados, banco de dados, migrations, containers e boas práticas de desenvolvimento.

Mais do que uma aplicação pronta, o projeto funciona como um **laboratório prático de aprendizado**, sendo desenvolvido de forma incremental. Cada nova funcionalidade representa uma oportunidade para estudar, implementar, testar e compreender melhor as tecnologias utilizadas no ecossistema Java.

---

## 🎯 Objetivo

O principal objetivo do **Aura Gestão** é transformar o aprendizado teórico em experiência prática através da construção progressiva de uma aplicação Backend real.

Durante o desenvolvimento, são explorados conceitos como:

* ☕ Java e Programação Orientada a Objetos
* 🌱 Spring Boot
* 🗃️ Persistência de dados com JPA/Hibernate
* 🐘 PostgreSQL
* 🔄 Versionamento de banco de dados com Flyway
* 🐳 Docker e Docker Compose
* 🔌 Desenvolvimento de APIs REST
* 🏗️ Organização e arquitetura de aplicações Backend
* 🧩 Modelagem de banco de dados
* 🔀 Git e GitHub
* ✅ Boas práticas de desenvolvimento

A arquitetura e as funcionalidades do sistema serão evoluídas conforme novos conceitos forem estudados e implementados.

---

## 🛠️ Tecnologias utilizadas

| Tecnologia              | Utilização                              |
| ----------------------- | --------------------------------------- |
| ☕ **Java 21**           | Linguagem principal                     |
| 🌱 **Spring Boot 4**    | Framework principal do Backend          |
| 🗃️ **Spring Data JPA** | Persistência e acesso aos dados         |
| 🔄 **Hibernate**        | Implementação JPA / ORM                 |
| 🐘 **PostgreSQL 17**    | Banco de dados relacional               |
| 🦋 **Flyway**           | Controle e versionamento das migrations |
| 🐳 **Docker**           | Containerização do ambiente             |
| 🐳 **Docker Compose**   | Orquestração do PostgreSQL              |
| 📦 **Maven**            | Gerenciamento do projeto e dependências |
| 🔀 **Git**              | Controle de versão                      |
| 🐙 **GitHub**           | Hospedagem e versionamento do código    |

---

## 🏗️ Organização do projeto

O projeto segue uma organização baseada na estrutura convencional de aplicações **Spring Boot**, mantendo o código separado dos recursos da aplicação e das migrations do banco de dados.

A estrutura atual está em evolução:

```text
aura-gestao-backend/
│
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │   └── 📁 com/
│   │   │       └── 📁 auragestao/
│   │   │           ├── 📁 entity/
│   │   │           │   └── User.java
│   │   │           │
│   │   │           └── AuraApplication.java
│   │   │
│   │   └── 📁 resources/
│   │       ├── 📁 db/
│   │       │   └── 📁 migration/
│   │       │       ├── V1__create_users.sql
│   │       │       └── V2__update_users_timestamp.sql
│   │       │
│   │       └── application.yml
│   │
│   └── 📁 test/
│
├── 🐳 docker-compose.yml
├── 📦 pom.xml
└── 📄 README.md
```

### 📌 Estrutura em evolução

A estrutura atual representa apenas a primeira etapa do desenvolvimento.

Conforme novas funcionalidades forem implementadas, novos pacotes deverão ser adicionados, como:

```text
com.auragestao/
├── controller/
├── service/
├── repository/
├── dto/
├── exception/
└── entity/
```

Esses pacotes serão incorporados gradualmente, de acordo com a evolução da aplicação e dos conceitos estudados.

> **A estrutura definitiva do projeto poderá ser ajustada durante o desenvolvimento**, buscando sempre melhorar organização, separação de responsabilidades e manutenção do código.

---

## 🗄️ Banco de dados

O projeto utiliza **PostgreSQL 17** como banco de dados relacional.

A primeira estrutura criada no banco é a tabela `users`.

### 👤 Tabela `users`

| Campo        | Tipo           | Regras                 |
| ------------ | -------------- | ---------------------- |
| `id`         | `BIGINT`       | Primary Key / Identity |
| `name`       | `VARCHAR(100)` | Obrigatório            |
| `phone`      | `VARCHAR(20)`  | Obrigatório            |
| `cpf`        | `VARCHAR(14)`  | Obrigatório            |
| `created_at` | `TIMESTAMP`    | Obrigatório            |
| `updated_at` | `TIMESTAMP`    | Obrigatório            |

A modelagem inicial está sendo utilizada para estudar a relação entre:

**Java → JPA → Hibernate → PostgreSQL**

---

## 🔄 Migrations com Flyway

O controle da estrutura do banco de dados é realizado utilizando **Flyway**.

As alterações são versionadas através de arquivos SQL, permitindo acompanhar a evolução do schema de maneira organizada.

### Migration inicial

```text
V1__create_users.sql
```

Responsável pela criação inicial da tabela `users`.

### Segunda migration

```text
V2__update_users_timestamp.sql
```

A segunda migration está sendo utilizada como estudo prático de atualização automática do campo `updated_at`.

O objetivo é utilizar recursos do próprio PostgreSQL, estudando a combinação de:

```text
Function
   ↓
Trigger
   ↓
updated_at
```

Dessa forma, o banco pode atualizar automaticamente o timestamp quando um registro for alterado.

---

## ☕ Entidade `User`

A entidade `User` está sendo construída utilizando **JPA**, através das anotações disponibilizadas pelo Jakarta Persistence.

Entre os conceitos estudados estão:

```java
@Entity
@Table
@Id
@GeneratedValue
@Column
```

A entidade também utiliza `LocalDateTime` para representar:

```text
createdAt
updatedAt
```

Essa etapa permite compreender na prática o mapeamento entre uma classe Java e uma tabela do banco de dados.

### 🔗 Relação conceitual

```text
┌─────────────────────┐
│      Java           │
│                     │
│       User          │
└──────────┬──────────┘
           │
           │ JPA
           ▼
┌─────────────────────┐
│     Hibernate       │
│        ORM          │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│    PostgreSQL 17    │
│                     │
│      users          │
└─────────────────────┘
```

---

## 🐳 Docker e PostgreSQL

O PostgreSQL é executado através de **Docker**, utilizando **Docker Compose**.

A utilização de containers permite manter o banco de dados isolado do ambiente local de desenvolvimento e facilita a reprodução do ambiente.

A aplicação Backend se conecta ao PostgreSQL executado pelo container.

Fluxo atual:

```text
Spring Boot
     │
     ▼
Database Configuration
     │
     ▼
PostgreSQL
     │
     ▲
     │
 Docker Compose
     │
     ▼
 PostgreSQL Container
```

---

## 📊 Status do projeto

O projeto está em **desenvolvimento ativo**.

### ✅ Concluído

* [x] Criar projeto Spring Boot
* [x] Configurar PostgreSQL
* [x] Configurar Docker Compose
* [x] Configurar Flyway
* [x] Criar primeira migration
* [x] Criar tabela `users`
* [x] Criar entidade `User`
* [x] Iniciar estudo da atualização automática de `updated_at`

### 🚧 Em desenvolvimento / planejado

* [ ] Implementar atualização automática de `updated_at`
* [ ] Criar Repository
* [ ] Criar Service
* [ ] Criar Controller
* [ ] Criar DTOs
* [ ] Implementar CRUD
* [ ] Implementar validações
* [ ] Implementar tratamento global de exceções
* [ ] Implementar autenticação e autorização
* [ ] Criar testes
* [ ] Documentar API com Swagger/OpenAPI

> **Observação:** o roadmap representa a direção planejada para evolução do projeto e pode ser alterado conforme novas necessidades e aprendizados surgirem durante o desenvolvimento.

---

## 🗺️ Roadmap

A evolução planejada do Aura Gestão segue aproximadamente esta direção:

```text
Fundação
   │
   ├── Java
   ├── Spring Boot
   ├── PostgreSQL
   ├── Docker
   └── Flyway
          │
          ▼
      Persistência
          │
          ├── Entity
          ├── Repository
          └── JPA / Hibernate
          │
          ▼
       Backend
          │
          ├── Service
          ├── Controller
          ├── DTO
          └── Exceptions
          │
          ▼
        API REST
          │
          ├── CRUD
          ├── Validações
          └── Documentação
          │
          ▼
     Qualidade
          │
          ├── Testes
          └── Segurança
```

O roadmap não representa necessariamente a ordem definitiva de implementação.

---

## 🚀 Como executar o projeto

### 📋 Pré-requisitos

Antes de executar o projeto, é necessário possuir:

* ☕ Java 21
* 🐳 Docker
* 🐳 Docker Compose
* 📦 Maven ou Maven Wrapper

### 1️⃣ Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre no diretório:

```bash
cd aura-gestao-backend
```

### 2️⃣ Subir o PostgreSQL

Execute:

```bash
docker compose up -d
```

Para verificar os containers:

```bash
docker compose ps
```

### 3️⃣ Executar a aplicação

Utilizando Maven:

```bash
mvn spring-boot:run
```

Ou, caso o projeto utilize o Maven Wrapper:

**Windows:**

```bash
.\mvnw spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw spring-boot:run
```

O Spring Boot realizará a inicialização da aplicação e o Flyway executará as migrations disponíveis conforme a configuração do projeto.

---

## 🧠 O que estou estudando com o Aura Gestão?

O projeto foi criado com uma abordagem prática.

Em vez de apenas estudar cada tecnologia separadamente, o objetivo é compreender como elas trabalham juntas dentro de uma aplicação Backend.

```text
Java
  ↓
Spring Boot
  ↓
Spring Data JPA
  ↓
Hibernate
  ↓
PostgreSQL
  ↓
Flyway
  ↓
Docker
```

Essa abordagem permite estudar não apenas **como utilizar uma tecnologia**, mas também **por que ela existe, qual problema resolve e como ela se encaixa na arquitetura da aplicação**.

---

## 📚 Filosofia do projeto

O Aura Gestão está sendo desenvolvido de maneira incremental.

Cada etapa do projeto representa uma oportunidade para:

* 🔎 entender um novo conceito;
* 🧠 aprofundar fundamentos;
* 💻 aplicar o conhecimento através de código;
* 🐛 identificar e resolver problemas;
* 🔄 refatorar quando necessário;
* 📈 evoluir tecnicamente junto com o projeto.

O objetivo não é simplesmente chegar rapidamente a uma aplicação final, mas construir uma base sólida de conhecimento em **Java e desenvolvimento Backend** através da prática.

---

## 👨‍💻 Autor

### Bruno Souza Lima

**Desenvolvedor de Software | Foco em Java e Backend**

O Aura Gestão faz parte da minha jornada de aprofundamento em **Java, Spring Boot e desenvolvimento Backend**, utilizando um projeto real como ambiente de estudo, experimentação e evolução técnica.

### 🔗 Conecte-se comigo

* 💻 **GitHub:** [eibrunodev](https://github.com/eibrunodev)
* 💼 **LinkedIn:** [Bruno Souza Lima](https://www.linkedin.com/in/bruno-souza-desenvolvedor/)

---

## ⭐ Sobre este repositório

Este repositório documenta a evolução do **Aura Gestão** desde sua fundação.

O código, a arquitetura e a estrutura do projeto serão modificados conforme novos conhecimentos forem adquiridos e novas funcionalidades forem implementadas.

> **Projeto pessoal desenvolvido para aprendizado prático, evolução técnica e construção de portfólio Backend com Java.**

---

<p align="center">
  ☕ Desenvolvido com Java &nbsp;•&nbsp; 🌱 Spring Boot &nbsp;•&nbsp; 🐘 PostgreSQL &nbsp;•&nbsp; 🐳 Docker
</p>

<p align="center">
  <strong>Aura Gestão</strong> — aprendendo, construindo e evoluindo.
</p>
