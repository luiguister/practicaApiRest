package com.example.ApiRest.domain.service;

import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.domain.repository.ProductRepository;
import com.example.ApiRest.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

        List<ProductDto> getAll();
        Optional<ProductDto> getProduct(int productId);
        Optional<List<ProductDto>> getByCategory(int categoryId);
        ProductDto save(ProductDto productDto);
        boolean delete(int productId);
        ProductDto updateProduct(ProductDto productDto);
}
