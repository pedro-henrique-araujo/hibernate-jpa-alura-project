package com.loja.repository;

import com.loja.model.Category;
import com.loja.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class ProductRepository {

    private EntityManager manager;

    public ProductRepository(EntityManager manager) {
        this.manager = manager;
    }

    public List<Product> getAll() {
        String jpql = "SELECT p FROM Product p";
        return manager.createQuery(jpql, Product.class).getResultList();
    }

    public BigDecimal getPrice(Long id) {
        String jpql = "SELECT p.price FROM Product p WHERE p.id = :id";
        return manager.createQuery(jpql, BigDecimal.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Product> getByCategory(String categoryName) {
        String jpql = "SELECT p FROM Product p WHERE p.category.name = :categoryName";
        TypedQuery query = manager.createQuery(jpql, Product.class);
        query.setParameter("categoryName", categoryName);
        return query.getResultList();
    }

    public List<Product> getByName(String name) {
        String jpql = "SELECT p FROM Product p WHERE p.name = :name";
        TypedQuery query = manager.createQuery(jpql, Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public Product get(Long id) {
        return manager.find(Product.class, id);
    }


    public void create(Product entity) {
        manager.persist(entity);
    }


    public void update(Product entity) {
        manager.merge(entity);
    }

    public void remove(Product entity) {
        Product managedEntity = manager.merge(entity);
        manager.remove(managedEntity);
    }
}
