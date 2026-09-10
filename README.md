# BJJ Bracket System

> Projeto educacional em Java para estudar modelagem de entidades, relacionamentos e persistência com Jakarta Persistence (JPA) e Hibernate.

## Visão geral

O projeto simula a preparação de uma chave de competição de Jiu-Jitsu. A aplicação de exemplo cria e persiste:

- Uma equipe (`Team`);
- Uma categoria (`Category`);
- Dois atletas (`Athlete`) associados à equipe e à categoria;
- Uma luta (`Match`) entre os dois atletas.

Depois da persistência, o programa consulta atletas de faixa branca com JPQL, busca as entidades pelo identificador e exibe seus relacionamentos no console.

Os dados são armazenados em um banco H2 em memória e, portanto, são apagados quando a aplicação é encerrada.

## Tecnologias

- Java 17
- Maven
- Jakarta Persistence 3.0
- Hibernate ORM 6.6.36.Final
- H2 Database 2.3.232
- JUnit Jupiter 5.12.2

## Pré-requisitos

- JDK 17 ou superior
- Maven instalado e disponível no `PATH`

Verifique o ambiente:

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

Também é possível executar a classe `com.estudos.jpa.Main` diretamente pela extensão Java do VS Code.

Durante a execução, a aplicação:

1. Cria uma equipe chamada `infight`.
2. Cria a categoria `Adult-White-Male-Heavy`, com idade máxima de 30 anos, peso máximo de 94,3 kg e faixa branca.
3. Cria os atletas `Rafah` e `Rafah2`.
4. Associa os dois atletas à equipe e à categoria.
5. Persiste uma luta entre os atletas.
6. Consulta atletas cuja faixa é `white` usando JPQL.
7. Exibe os dados consultados e a quantidade de atletas da equipe e da categoria.

## Modelo de domínio

### `Athlete`

Representa um atleta com nome, idade, gênero, peso e faixa. Possui relacionamentos `ManyToOne` com `Team` e `Category`.

### `Team`

Representa uma equipe e mantém uma coleção de atletas por meio de um relacionamento `OneToMany`.

### `Category`

Representa uma categoria de competição, com nome, idade máxima, peso máximo, faixa, gênero e uma coleção de atletas.

### `Match`

Representa uma luta entre dois atletas (`athlete1` e `athlete2`) dentro de uma categoria.

## Relacionamentos

```text
Team 1 -------- N Athlete N -------- 1 Category
                         |
                         N
                       Match
```

- `Team` -> `Athlete`: `OneToMany` bidirecional;
- `Category` -> `Athlete`: `OneToMany` bidirecional;
- `Athlete` -> `Team`: `ManyToOne`;
- `Athlete` -> `Category`: `ManyToOne`;
- `Match` -> `Athlete`: dois relacionamentos `ManyToOne`;
- `Match` -> `Category`: `ManyToOne`.

## Estrutura do projeto

```text
src/
└── main/
    ├── java/com/estudos/jpa/
    │   ├── Main.java
    │   └── entities/
    │       ├── Athlete.java
    │       ├── Category.java
    │       ├── Match.java
    │       └── Team.java
    └── resources/META-INF/
        └── persistence.xml
```

## Configuração de persistência

A unidade de persistência `bjjBracketSystem` está definida em `src/main/resources/META-INF/persistence.xml` e utiliza:

- H2 em memória: `jdbc:h2:mem:bjj;DB_CLOSE_DELAY=-1`;
- Transações locais (`RESOURCE_LOCAL`);
- Geração automática do esquema com `create-drop`;
- Logs SQL formatados e habilitados;
- Registro explícito das entidades `Athlete`, `Team`, `Category` e `Match`.

## Conceitos praticados

- Entidades JPA com `@Entity`;
- Identificadores gerados com `@GeneratedValue`;
- Chaves estrangeiras com `@JoinColumn`;
- Relacionamentos `@OneToMany` e `@ManyToOne`;
- Transações com `EntityManager`;
- Consultas tipadas com JPQL;
- Persistência e recuperação de entidades relacionadas;
- Configuração de Hibernate e H2 por `persistence.xml`.

## Próximos passos

- Adicionar testes automatizados para persistência e relacionamentos;
- Validar se o atleta atende aos limites da categoria antes da inscrição;
- Criar consultas para listar lutas por categoria ou equipe;
- Substituir o H2 em memória por um banco persistente quando o modelo estiver consolidado.

## Licença

Este projeto é destinado a estudos e experimentação com JPA e Hibernate.
