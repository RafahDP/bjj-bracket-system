package com.estudos.jpa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Team {
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

    

}
