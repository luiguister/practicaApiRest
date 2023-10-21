package com.example.ApiRest.web.controller;

import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.domain.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;


   /*@GetMapping("/all")
    public List<ProductDto> getAll(){
        return service.getAll();
    }*/

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(service.save(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") int productId){
        return service.getProduct(productId)
                .map(ResponseEntity::ok)
                .orElseGet( ()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int idProduct){
        service.delete(idProduct);
        return new ResponseEntity<>("Producto eliminado", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") int idProduct, @RequestBody ProductDto productDto){
        return service.getProduct(idProduct)
                .map(saveProduct -> {
                    saveProduct.setName(productDto.getName());
                    saveProduct.setPrice(productDto.getPrice());
                    saveProduct.setStock(productDto.getStock());
                    saveProduct.setActive(productDto.isActive());

                    ProductDto updateProduct = service.updateProduct(saveProduct);
                    return new ResponseEntity<>(updateProduct, HttpStatus.OK);
                })
                .orElseGet( () -> ResponseEntity.notFound().build());
    }
}
