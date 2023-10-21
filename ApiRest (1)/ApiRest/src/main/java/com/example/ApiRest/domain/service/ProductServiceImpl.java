package com.example.ApiRest.domain.service;

import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDto> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Optional<ProductDto> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        /*Optional<ProductDto> saveProduct = productRepository.getByName(productDto.getName());
        if(saveProduct.isPresent()){
            throw new ResourceNotFoundException("El nombre ya existe "+ productDto.getName());
        }*/
        return productRepository.save(productDto);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return productRepository.save(productDto);
    }


}
