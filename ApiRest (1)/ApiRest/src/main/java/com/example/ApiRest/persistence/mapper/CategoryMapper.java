package com.example.ApiRest.persistence.mapper;


import com.example.ApiRest.domain.CategoryDto;
import com.example.ApiRest.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.io.Serializable;

@Mapper(componentModel = "spring")
public interface CategoryMapper{
    @Mappings({
            @Mapping(source = "idCategory", target="categoryId"),
            @Mapping(source = "description", target="description"),
            @Mapping(source = "state", target="active")
    })
    CategoryDto toCategoryDto(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategory(CategoryDto categoryDto);
}
