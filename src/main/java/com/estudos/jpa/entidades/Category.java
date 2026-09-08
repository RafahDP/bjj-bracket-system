package com.estudos.jpa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category_name;
    private float max_weight;
    private int max_age;
    private String belt;
    private String gender;
    // Getters and setters
    public Category() {}
    
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCategory_name(){
        return category_name;
    }
    public void setCategory_name(String category_name){
        this.category_name = category_name;
    }
    public float getMax_weight(){
        return max_weight;
    }
    public void setMax_weight(float max_weight){
        this.max_weight = max_weight;
    }
    public int getMax_age(){
        return max_age;
    }
    public void setMax_age(int max_age){
        this.max_age = max_age;
    }
    public String getBelt(){
        return belt;
    }
    public String getGender(){
        return gender;
    }
    public void setBelt(String belt){
        this.belt = belt;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
}
