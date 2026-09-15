package com.estudos.jpa.repositories;

import com.estudos.jpa.entities.Match;

import jakarta.persistence.EntityManager;

public class MatchRepositories {
    private final EntityManager em;
    
    public MatchRepositories(EntityManager em){
        this.em= em;
    }
    public void saveMatch(Match match){
        em.persist(match);
    }
    public Match findMatch(Long id){
        return em.find(Match.class,id);
    }
}
