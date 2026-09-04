# JPA Hibernate Estudos

Projeto didatico para praticar JPA com Hibernate e banco H2 em memoria.

## Requisitos

- Java 17 ou superior
- Maven 3.9 ou superior

## Executar

```bash
mvn clean package
mvn exec:java
```

A aplicacao cria um departamento, associa um funcionario e lista os dados persistidos. Como o banco usa H2 em memoria, os dados sao apagados ao encerrar a aplicacao.

## Estrutura

- `Main.java`: inicializacao do EntityManagerFactory e exemplo de persistencia
- `entidades/BaseEntity.java`: id comum das entidades
- `entidades/Departamento.java`: entidade com relacionamento um-para-muitos
- `entidades/Funcionario.java`: entidade com relacionamento muitos-para-um
- `persistence.xml`: configuracao da unidade de persistencia
