package com.apiUnitTest.apiUnitTest.domain.services;

import com.apiUnitTest.apiUnitTest.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAll();
    Optional<Product> getById(int idProduct);
    Product updateProduct(Product product);
    void deleteProduct(int idproduct);
}
