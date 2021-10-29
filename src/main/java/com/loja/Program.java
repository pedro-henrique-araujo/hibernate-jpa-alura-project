package com.loja;

import com.loja.model.Product;
import com.loja.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Program {
    public static void main(String[] args) {
        //System.out.println("Don't worry, be happy \uD83D\uDE0E");

        Product product = new Product();
        product.setName("Motorola - Moto G5");
        product.setDescription("So cool!");
        product.setPrice(new BigDecimal("1599.99"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        ProductRepository repository = new ProductRepository(manager);
        repository.create(product);
        transaction.commit();
        manager.close();
    }
}
