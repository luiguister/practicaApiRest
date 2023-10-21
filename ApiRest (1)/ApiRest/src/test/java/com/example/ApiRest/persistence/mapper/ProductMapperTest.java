package com.example.ApiRest.persistence.mapper;

import com.example.ApiRest.domain.CategoryDto;
import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.persistence.entity.Category;
import com.example.ApiRest.persistence.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    private Product product;
    private ProductDto productDto;
    private List<ProductDto> productDtoList;
    private List<Product> productList;

    @BeforeEach
    void setUp() {
        Category category = new Category(1, "descripcion", true);
        product = new Product(1, "product1", 1, "151asdf", 15000.0, 18, true, category);
        CategoryDto categoryDto = new CategoryDto(1, "descripcion", true);
        productDto = new ProductDto(1, "product1", 1, 15000.0, 18, true, categoryDto);
        productDtoList = new ArrayList<>();
        productDtoList.add(productDto);
        productList = new ArrayList<>();
        productList.add(product);
    }

    @Test
    void toProductDto() {
        ProductMapper converter = Mappers.getMapper(ProductMapper.class);
        /*assertEquals(productDto.getProductId(), converter.toProductDto(product).getProductId());
        assertEquals(productDto.getName(), converter.toProductDto(product).getName());
        assertEquals(productDto.getCategoryId(), converter.toProductDto(product).getCategoryId());
        assertEquals(productDto.getPrice(), converter.toProductDto(product).getPrice());
        assertEquals(productDto.getStock(), converter.toProductDto(product).getStock());
        assertEquals(productDto.isActive(), converter.toProductDto(product).isActive());
        assertEquals(productDto.getCategoryDto().getCategoryId(), converter.toProductDto(product).getCategoryDto().getCategoryId());
        assertEquals(productDto.getCategoryDto().getDescription(), converter.toProductDto(product).getCategoryDto().getDescription());
        assertEquals(productDto.getCategoryDto().isActive(), converter.toProductDto(product).getCategoryDto().isActive());*/
        /*assertEquals(productDto.getProductId(), product.getIdProduct());
        assertEquals(productDto.getName(), product.getName());
        assertEquals(productDto.getCategoryId(), product.getIdCategory());
        assertEquals(productDto.getPrice(), product.getSellPrice());
        assertEquals(productDto.getStock(), product.getStock());
        assertEquals(productDto.isActive(), product.getState());
        assertEquals(productDto.getCategoryDto().getCategoryId(), product.getCategory().getIdCategory());
        assertEquals(productDto.getCategoryDto().getDescription(), product.getCategory().getDescription());
        assertEquals(productDto.getCategoryDto().isActive(), product.getCategory().getState());*/


    }

    @Test
    void toProductsDto() {
        ProductMapper converter = Mappers.getMapper(ProductMapper.class);
        /*assertEquals(productDto.getProductId(), converter.toProductsDto(productList).get(0).getProductId());
        assertEquals(productDto.getName(), converter.toProductsDto(productList).get(0).getName());
        assertEquals(productDto.getCategoryId(), converter.toProductsDto(productList).get(0).getCategoryId());
        assertEquals(productDto.getPrice(), converter.toProductsDto(productList).get(0).getPrice());
        assertEquals(productDto.getStock(), converter.toProductsDto(productList).get(0).getStock());
        assertEquals(productDto.isActive(), converter.toProductsDto(productList).get(0).isActive());
        assertEquals(productDto.getCategoryDto().getCategoryId(), converter.toProductsDto(productList).get(0).getCategoryDto().getCategoryId());
        assertEquals(productDto.getCategoryDto().getDescription(), converter.toProductsDto(productList).get(0).getCategoryDto().getDescription());
        assertEquals(productDto.getCategoryDto().isActive(), converter.toProductsDto(productList).get(0).getCategoryDto().isActive());*/
    }

    @Test
    void toProduct() {
        ProductMapper converter = Mappers.getMapper(ProductMapper.class);
        /*assertEquals(product.getIdProduct(), converter.toProductDto(product).getProductId());
        assertEquals(product.getName(), converter.toProductDto(product).getName());
        assertEquals(product.getIdCategory(), converter.toProductDto(product).getCategoryId());
        assertEquals(product.getSellPrice(), converter.toProductDto(product).getPrice());
        assertEquals(product.getStock(), converter.toProductDto(product).getStock());
        assertEquals(product.getState(), converter.toProductDto(product).isActive());
        assertEquals(product.getCategory().getIdCategory(), converter.toProductDto(product).getCategoryDto().getCategoryId());
        assertEquals(product.getCategory().getDescription(), converter.toProductDto(product).getCategoryDto().getDescription());
        assertEquals(product.getCategory().getState(), converter.toProductDto(product).getCategoryDto().isActive());*/
        /*assertEquals(product.getIdProduct(), productDto.getProductId());
        assertEquals(product.getName(), productDto.getName());
        assertEquals(product.getIdCategory(), productDto.getCategoryId());
        assertEquals(product.getSellPrice(), productDto.getPrice());
        assertEquals(product.getStock(), productDto.getStock());
        assertEquals(product.getState(), productDto.isActive());
        assertEquals(product.getCategory().getIdCategory(), productDto.getCategoryDto().getCategoryId());
        assertEquals(product.getCategory().getDescription(), productDto.getCategoryDto().getDescription());
        assertEquals(product.getCategory().getState(), productDto.getCategoryDto().isActive());*/
    }

    @Test
    void toProducts(){
        ProductMapper converter = Mappers.getMapper(ProductMapper.class);
        /*assertEquals(product.getIdProduct(), converter.toProducts(productDtoList).get(0).getIdProduct());
        assertEquals(product.getName(), converter.toProducts(productDtoList).get(0).getName());
        assertEquals(product.getIdCategory(), converter.toProducts(productDtoList).get(0).getIdCategory());
        assertEquals(product.getSellPrice(), converter.toProducts(productDtoList).get(0).getSellPrice());
        assertEquals(product.getStock(), converter.toProducts(productDtoList).get(0).getStock());
        assertEquals(product.getState(), converter.toProducts(productDtoList).get(0).getState());
        assertEquals(product.getCategory(), converter.toProducts(productDtoList).get(0).getCategory());*/
    }
}