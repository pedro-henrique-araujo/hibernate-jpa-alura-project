package com.loja.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_product")
@NoArgsConstructor
public class Product {

    public Product(String name, String description, BigDecimal price, Category category) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory(category);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDate date = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Category category;
}
