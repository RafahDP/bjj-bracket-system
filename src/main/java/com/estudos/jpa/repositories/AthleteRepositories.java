package com.estudos.jpa.repositories;


import com.estudos.jpa.entities.Athlete;

import jakarta.persistence.EntityManager;

public class AthleteRepositories {

    private final EntityManager em;

    public AthleteRepositories(EntityManager em) {
        this.em = em;
    }
    public void saveAthlete(Athlete athlete) {
        em.persist(athlete);
    }
    public Athlete findAthlete(Long id){
        return em.find(Athlete.class,id);
    }
    

}