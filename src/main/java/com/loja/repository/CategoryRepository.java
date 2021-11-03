package com.loja.repository;

import com.loja.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class CategoryRepository {
    private EntityManager manager;

    public CategoryRepository(EntityManager manager) {
        this.manager = manager;
    }

    public List<Category> getAll() {
        String jpql = "SELECT c FROM Category c";
        return manager.createQuery(jpql, Category.class).getResultList();
    }

    public List<Category> getByName(String name) {
        String jpql = "SELECT c FROM Category c WHERE c.name = :name";
        //String jpql = "SELECT c FROM Category c WHERE c.name = ?1";
        TypedQuery query = manager.createQuery(jpql, Category.class);
        //query.setParameter(1, name);
        query.setParameter("name", name);
        return query.getResultList();
    }



    public Category get(int id) {
        return manager.find(Category.class, id);
    }

    public void create(Category entity) {
        manager.persist(entity);
    }

    public void update(Category entity) {
        manager.merge(entity);
    }

    public void remove(Category entity) {
        Category managedEntity = manager.merge(entity);
        manager.remove(managedEntity);
    }


}
