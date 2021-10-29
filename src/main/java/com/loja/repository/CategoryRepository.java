package com.loja.repository;

import com.loja.model.Category;

import javax.persistence.EntityManager;

public class CategoryRepository {
    private EntityManager manager;

    public CategoryRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Category entity) {
        manager.persist(entity);
    }
}
