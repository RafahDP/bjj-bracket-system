package com.estudos.jpa.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity 
public class Team {
    @OneToMany (mappedBy = "team")
    private List<Athlete> athletes;
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String teamName;

    public Team(){}
    public void setTeamName (String teamName){
        this.teamName = teamName;
    }
    public String getTeamName(){
        return this.teamName;
    }
    public void setAthletes(List<Athlete> athletes){
        this.athletes = athletes;
    }
    public List<Athlete> getAthletes() {
        return athletes;
    }

    

}
