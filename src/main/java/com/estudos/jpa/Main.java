package com.estudos.jpa;

import com.estudos.jpa.entidades.Athlete;
import com.estudos.jpa.entidades.Team;

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
        Athlete athlete = new Athlete();
        athlete.setName("Rafah");
        athlete.setTeam(team);
        athlete.setAge(20);
        athlete.setWeight(94.30f);
        athlete.setBelt("white");   
        
        em.persist(athlete);
        em.getTransaction().commit();

        System.out.println("dados salvos com sucesso!");
        
        Athlete findAthlete = em.find(Athlete.class, 1L);
        
        // debug
        System.out.println("----Dados Consultados no banco ----");
        System.out.println("Nome: " + findAthlete.getName());
        System.out.println("Idade: " + findAthlete.getAge());
        System.out.println("Peso: " + findAthlete.getWeight());
        System.out.println("Faixa: " + findAthlete.getBelt());

        em.close();
        emf.close();
        }


}