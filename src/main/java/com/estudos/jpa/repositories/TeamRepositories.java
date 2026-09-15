package com.estudos.jpa.repositories;

import com.estudos.jpa.entities.Team;

import jakarta.persistence.EntityManager;


public class TeamRepositories {
    private final EntityManager em;

    public TeamRepositories(EntityManager em){
        this.em = em;
    }
    public void saveTeam(Team team){
        em.persist(team);
    }
    public Team findTeam(Long id){
        return em.find(Team.class,id);
    }

}
