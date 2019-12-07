package com.biniek.sylwia.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository repository;

    @Test
    public void testFindByCreditId() {

        List<Long> credits = new ArrayList<Long>();
        credits.add(Long.valueOf(1));
        credits.add(Long.valueOf(2));
        entityManager.persist(new Customer(Long.valueOf(1), "Johnny", "6626070", "Bravo"));

        List<Customer> Johnny = repository.findAllById(credits);
        assertEquals(1, Johnny.size());

        assertThat(Johnny).extracting(Customer::getCreditId).containsOnly(Long.valueOf(1));
        assertThat(Johnny).extracting(Customer::getFirstName).containsOnly("Johnny");
        assertThat(Johnny).extracting(Customer::getSurname).containsOnly("Bravo");
        assertThat(Johnny).extracting(Customer::getPesel).containsOnly("6626070");

    }

}
