package com.example.ApiRest.domain.repository;

import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDto> getAll();
    Optional<List<ProductDto>> getByCategory(int categoryId);
    Optional<List<ProductDto>> getScarseProduct(int quantity);
    Optional<ProductDto> getProduct(int productId);
    Optional<ProductDto> getByName(String name);
    ProductDto save(ProductDto productDto);
    boolean delete(int productId);
}
