package com.estudos.jpa.repositories;

import com.estudos.jpa.entities.Category;

import jakarta.persistence.EntityManager;

public class CategoryRepositories {
    private final EntityManager em;
    
    public CategoryRepositories(EntityManager em){
        this.em = em;
    }
    public void saveCategory(Category category){
        em.persist(category);
    }
    public Category findCategory(Long id){
       return em.find(Category.class, id);

    }
}
