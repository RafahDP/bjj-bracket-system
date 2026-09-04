# BJJ Bracket System

> Projeto educacional em Java para modelagem e persistência de atletas e equipes de Jiu-Jitsu utilizando JPA e Hibernate.

## Visão geral

Este projeto demonstra um fluxo básico de persistência com Jakarta Persistence:

1. Criação de uma unidade de persistência com `EntityManagerFactory`.
2. Criação de uma equipe e de um atleta.
3. Associação do atleta à equipe.
4. Persistência das entidades em uma transação.
5. Consulta do atleta pelo identificador e exibição dos dados no console.

O banco utilizado atualmente é o H2 em memória. Por isso, os dados são descartados quando a aplicação é encerrada.

## Tecnologias

- Java 17+
- Maven 3.9+
- Jakarta Persistence 3.0
- Hibernate ORM 6.6
- H2 Database 2.3
- JUnit Jupiter 5.12

## Pré-requisitos

Instale:

- JDK 17 ou superior
- Maven 3.9 ou superior

Verifique o ambiente com:

```bash
java -version
mvn -version
```

## Como executar

Na raiz do projeto, compile e execute:

```bash
mvn clean package
mvn exec:java
```

Ao final, a aplicação persiste os dados de exemplo e exibe no console:

```text
dados salvos com sucesso!
----Dados Consultados no banco ----
```

## Modelo de domínio

### `Athlete`

Representa um atleta, com nome, idade, peso e faixa. Possui um relacionamento `ManyToOne` com `Team`.

### `Team`

Representa a equipe associada ao atleta.

### `Category`

Representa uma categoria de competição, com limites de peso e idade, faixa e gênero. A classe já está modelada como entidade, mas ainda não está registrada no arquivo `persistence.xml`.

## Estrutura do projeto

```text
src/
└── main/
	├── java/com/estudos/jpa/
	│   ├── Main.java
	│   └── entidades/
	│       ├── Athlete.java
	│       ├── Category.java
	│       └── Team.java
	└── resources/META-INF/
		└── persistence.xml
```

## Configuração de persistência

A unidade de persistência `bjjBracketSystem` está definida em `src/main/resources/META-INF/persistence.xml` e utiliza:

- H2 em memória: `jdbc:h2:mem:bjj`
- Geração automática do esquema: `create-drop`
- Transações locais (`RESOURCE_LOCAL`)
- Logs SQL habilitados para facilitar o estudo do comportamento do Hibernate

As entidades `Athlete` e `Team` estão registradas explicitamente no arquivo de configuração.

## Boas práticas demonstradas

- Encapsulamento por meio de atributos privados e métodos getters/setters.
- Identificadores gerados automaticamente com `@GeneratedValue`.
- Relacionamento entre entidades com `@ManyToOne` e `@JoinColumn`.
- Uso explícito de transações para operações de persistência.
- Fechamento do `EntityManager` e do `EntityManagerFactory` após o uso.

## Próximos passos

- Registrar `Category` na unidade de persistência.
- Criar associações entre atletas e categorias.
- Adicionar testes automatizados para persistência e relacionamentos.
- Substituir o H2 por um banco persistente quando o modelo estiver consolidado.

## Licença

Este projeto é destinado a estudos e experimentação com JPA e Hibernate.
