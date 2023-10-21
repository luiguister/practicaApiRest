package com.apiUnitTest.apiUnitTest.domain.services;

import com.apiUnitTest.apiUnitTest.domain.repository.ProductRepository;
import com.apiUnitTest.apiUnitTest.exceptions.ResourceNotFoundException;
import com.apiUnitTest.apiUnitTest.persistence.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        Optional<Product> saveProduct = productRepository.findByCategory(product.getIdCategory());
        if(saveProduct.isEmpty()){
            throw new ResourceNotFoundException("La categoria no existe");
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(int idProduct) {
        return productRepository.findById(idProduct);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int idproduct) {
        productRepository.deleteById(idproduct);
    }
}
