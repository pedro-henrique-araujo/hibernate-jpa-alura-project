package com.loja.repository;

import com.loja.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductRepository {

    private EntityManager manager;

    public ProductRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void create(Product entity) {
        manager.persist(entity);
    }
}
