package com.apiUnitTest.apiUnitTest.domain.repository;

import com.apiUnitTest.apiUnitTest.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByCategory(int id);

}
