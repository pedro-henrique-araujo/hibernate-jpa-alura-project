package com.loja;

import com.loja.model.Category;
import com.loja.model.Product;
import com.loja.repository.CategoryRepository;
import com.loja.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ProductRepository repository = createProductRepository();

        BigDecimal result = repository.getPrice(1l);
        System.out.println(result);
    }


    public static ProductRepository createProductRepository() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager manager = factory.createEntityManager();
        return new ProductRepository(manager);
    }
}
