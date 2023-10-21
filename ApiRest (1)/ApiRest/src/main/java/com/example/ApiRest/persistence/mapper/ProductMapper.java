package com.example.ApiRest.persistence.mapper;

import com.example.ApiRest.domain.ProductDto;
import com.example.ApiRest.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "sellPrice", target = "price"),
            @Mapping(source = "stock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "categoryDto")
    })
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductsDto(List<Product> product);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProduct(ProductDto productDto);

    //@InheritInverseConfiguration
    List<Product> toProducts(List<ProductDto> productsDto);
}