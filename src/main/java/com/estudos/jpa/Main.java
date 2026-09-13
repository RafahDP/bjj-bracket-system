package com.estudos.jpa;

import java.util.List;

import com.estudos.jpa.entities.Athlete;
import com.estudos.jpa.entities.Category;
import com.estudos.jpa.entities.Match;
import com.estudos.jpa.entities.Team;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Main{
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bjjBracketSystem");
        EntityManager em = emf.createEntityManager();   
        em.getTransaction().begin();
        Team team = new Team();
        team.setTeamName("infight");
        em.persist(team);
        Category category = new Category();
        category.setCategory_name("Adult-White-Male-Heavy");
        
        
        category.setMax_age(30);
        category.setMax_weight(94.300f);
        category.setBelt("white");
        
        em.persist(category);
        Athlete athlete = new Athlete();
        athlete.setName("Rafah");
        athlete.setTeam(team);
        team.getAthletes().add(athlete);
        category.getAthletes().add(athlete);
        athlete.setAge(20);
        athlete.setWeight(94.30f);
        athlete.setBelt("white");  
        athlete.setGender("male");
        athlete.setCategory(category);
        athlete.setIsFighting("yes");

        Athlete athlete2 = new Athlete();
        athlete2.setName("Rafah2");
        athlete2.setTeam(team);
        team.getAthletes().add(athlete2);
        category.getAthletes().add(athlete2);
        athlete2.setAge(25);
        athlete2.setWeight(94.300f);
        athlete2.setBelt("white");
        athlete2.setGender("male");
        athlete2.setCategory(category);
        athlete2.setIsFighting("yes");
        

        em.persist(athlete);
        em.persist(athlete2);

        Match match = new Match();
        match.setAthlete1(athlete);
        match.setAthlete2(athlete2);
        match.setCategory(category);
        match.setWinner(athlete);
        match.setMatchStatus("happening");
        em.persist(match);

        em.getTransaction().commit();

        String jpql = "SELECT a FROM Athlete a WHERE a.belt = :belt";
        List<Athlete> athletes = em.createQuery(jpql, Athlete.class)
            .setParameter("belt", "white")
            .getResultList();
        System.out.println("Atletas encontrados: " + athletes.size());

        
        System.out.println("dados salvos com sucesso!");
        
        Athlete findAthlete = em.find(Athlete.class, 1L);
        Team findTeam = em.find(Team.class,1L);
        Category findCategory = em.find(Category.class, 1L);
        Match findMatch = em.find(Match.class,1L);
        // debug
        System.out.println("----Dados Consultados no banco ----");
        System.out.println("Nome: " + findAthlete.getName());
        System.out.println("Idade: " + findAthlete.getAge());
        System.out.println("Peso: " + findAthlete.getWeight());
        System.out.println("Faixa: " + findAthlete.getBelt());
        System.out.println("Time: " + findAthlete.getTeam().getTeamName());
        System.out.println("Categoria: " + findAthlete.getCategory().getCategory_name());
        System.out.println("Quantidade de atletas na equipe: " + findTeam.getAthletes().size());
        System.out.println("Atletas na Categoria:"+ findCategory.getAthletes().size());
        System.out.println("Match encontrado: " + findMatch.getAthlete1().getName() + " vs " + findMatch.getAthlete2().getName() + " na categoria: " + findMatch.getCategory().getCategory_name());
        System.out.println("Status do Match: " + findMatch.getMatchStatus());
        System.out.println("Vencedor do Match: " + findMatch.getWinner().getName());
        System.out.println("Atleta:"+ findAthlete.getName()+" está lutando?: " + findAthlete.getIsFighting());

        for (int i=0 ; i<2;i++){
            System.out.println("Checando atleta:"+ athletes.get(i).getName());
        }
        
        em.close();
        emf.close();
        }


}