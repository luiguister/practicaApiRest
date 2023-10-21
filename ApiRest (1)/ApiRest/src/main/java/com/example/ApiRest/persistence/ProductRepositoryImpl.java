package com.example.ApiRest.persistence;

import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.domain.repository.ProductRepository;
import com.example.ApiRest.persistence.crud.ProductCrudRepository;
import com.example.ApiRest.persistence.entity.Product;
import com.example.ApiRest.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return productMapper.toProductsDto(products);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(productMapper.toProductsDto(products));
    }

    @Override
    public Optional<List<ProductDto>> getScarseProduct(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndState(quantity, true);
        return products.map(prods -> productMapper.toProductsDto(prods));
    }

    @Override
    public Optional<ProductDto> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> productMapper.toProductDto(product));
    }

    @Override
    public Optional<ProductDto> getByName(String name) {
        return productCrudRepository.findByName(name).map(product -> productMapper.toProductDto(product));

    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        return productMapper.toProductDto(productCrudRepository.save(product));
    }

    @Override
    public boolean delete(int productId) {
        if(productCrudRepository.findById(productId).map(product -> productMapper.toProductDto(product)).isEmpty()){
            return false;
        }else
            productCrudRepository.deleteById(productId);
            return true;


    }

}
