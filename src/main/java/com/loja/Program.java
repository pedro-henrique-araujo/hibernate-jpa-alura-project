package com.loja;

import com.loja.model.Category;
import com.loja.model.Product;
import com.loja.repository.CategoryRepository;
import com.loja.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Program {
    public static void main(String[] args) {
        //System.out.println("Don't worry, be happy \uD83D\uDE0E");
        Category category = new Category("PHONE");
        Product product = new Product(
                "Motorola - Moto G5",
                "So cool!",
                new BigDecimal("1599.99"),
                category
            );


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        CategoryRepository categoryRepository = new CategoryRepository(manager);
        ProductRepository repository = new ProductRepository(manager);
        categoryRepository.create(category);
        repository.create(product);
        transaction.commit();
        manager.close();
    }
}
