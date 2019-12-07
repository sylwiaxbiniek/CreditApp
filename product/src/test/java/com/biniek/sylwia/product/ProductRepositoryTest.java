package com.biniek.sylwia.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository repository;

    @Test
    public void testFindByCreditId() {

        List<Long> credits = new ArrayList<Long>();
        credits.add(Long.valueOf(1));
        credits.add(Long.valueOf(2));
        entityManager.persist(new Product(Long.valueOf(1), "Dummy Product", 10));

        List<Product> products = repository.findAllById(credits);
        assertEquals(1, products.size());

        assertThat(products).extracting(Product::getCreditId).containsOnly(Long.valueOf(1));
        assertThat(products).extracting(Product::getProductName).containsOnly("Dummy Product");
        assertThat(products).extracting(Product::getValue).containsOnly(10);

    }

}
