package com.example.ApiRest.domain.service;

import com.example.ApiRest.domain.CategoryDto;
import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    private CategoryDto categoryDto;
    private ProductDto productDto;

    @BeforeEach
    void setUp() {
        categoryDto = new CategoryDto(1, "descripcion", true);
        productDto = new ProductDto(1, "newProduct", 1, 10000.0, 5, true, categoryDto);
    }

    @Test
    @DisplayName("test to save products")
    void givenProductObject(){
        given(productRepository.save(productDto)).willReturn(productDto);
        // when - action
        ProductDto savedProduct = productService.save(productDto);
        // then - verify
        assertNotNull(savedProduct);
    }

    @Test
    @DisplayName("test to list products")
    void givenProductList(){

        CategoryDto categoryDto1 = new CategoryDto(1, "descripcion", true);
        ProductDto productDto1 = new ProductDto(1, "newProduct1", 1, 10000.0, 5, true, categoryDto1);
        given(productRepository.getAll()).willReturn(List.of(productDto, productDto1));
        // when - action
        List<ProductDto> productDtoList = productService.getAll();
        // then - verify output
        assertAll(
                () -> assertNotNull(productDtoList),
                () -> assertEquals(productDtoList.size(), 2)
        );
    }

    @Test
    @DisplayName("test to get product")
    void givenProduct(){
        given(productRepository.getProduct(productDto.getProductId())).willReturn(Optional.ofNullable(productDto));
        Optional<ProductDto> productDto1 = productService.getProduct(productDto.getProductId());
        assertNotNull(productDto1);
    }

    /*@Test
    @DisplayName("test to delete product")
    void givenProductToDelete(){
        CategoryDto categoryDto1 = new CategoryDto(1, "descripcion", true);
        ProductDto productDto1 = new ProductDto(1, "newProduct1", 1, 10000.0, 5, true, categoryDto1);
        given(productRepository.delete(productDto1.getProductId())).willReturn(true);
        List<ProductDto> productDtoList = productService.getAll();

        assertTrue(productService.delete(productDto.getProductId()));
        assertEquals(productService.getAll().size(), 1);

    }*/
}