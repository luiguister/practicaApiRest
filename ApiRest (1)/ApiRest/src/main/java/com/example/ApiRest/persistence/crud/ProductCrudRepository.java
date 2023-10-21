package com.example.ApiRest.persistence.crud;

import com.example.ApiRest.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product,Integer> {


    /*@Query(value = "SELECT * FROM products ORDER BY name", nativeQuery = true)*/

    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<Product>> findByStockLessThanAndState(int stock, boolean state);
    Optional<Product> findByIdCategory(int idCategory);
    Optional<Product> findByName(String name);
}
