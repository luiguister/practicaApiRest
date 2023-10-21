package com.apiUnitTest.apiUnitTest.controllers;

import com.apiUnitTest.apiUnitTest.domain.services.ProductServiceImpl;
import com.apiUnitTest.apiUnitTest.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        return productService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product){
        return productService.getById(id)
                .map(saveProduct -> {
                    saveProduct.setBarcode(product.getBarcode());
                    saveProduct.setName(product.getName());
                    saveProduct.setSellPrice(product.getSellPrice());
                    saveProduct.setStock(product.getStock());
                    saveProduct.setState(product.getState());

                    Product updateProduct = productService.updateProduct(saveProduct);
                    return new ResponseEntity<>(updateProduct, HttpStatus.OK);
                })
                .orElseGet( () -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Producto eliminado",HttpStatus.OK);
    }
}
