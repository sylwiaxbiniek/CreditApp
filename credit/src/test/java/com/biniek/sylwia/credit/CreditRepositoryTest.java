package com.biniek.sylwia.credit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class CreditRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CreditRepository repository;

    @Test
    public void testFindAll() {

        entityManager.persist(new Credit(Long.valueOf(1), "Dummy Name"));

        List<Credit> credits = repository.findAll();
        assertEquals(1, credits.size());

        assertThat(credits).extracting(Credit::getCreditId).containsOnly(Long.valueOf(1));
        assertThat(credits).extracting(Credit::getCreditName).containsOnly("Dummy Name");

    }

}
