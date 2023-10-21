package com.example.ApiRest.persistence.mapper;

import com.example.ApiRest.domain.CategoryDto;
import com.example.ApiRest.persistence.entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {
    private Category category;
    private CategoryDto categoryDto;

    @BeforeEach
    void setUp() {
        category = new Category(1, "descripcion", true);
        categoryDto = new CategoryDto(1, "descripcion", true);
    }

    @Test
    void toCategoryDto() {
        CategoryMapper converter = Mappers.getMapper(CategoryMapper.class);
        assertEquals(categoryDto.getCategoryId(), converter.toCategoryDto(category).getCategoryId());
        assertEquals(categoryDto.getDescription(), converter.toCategoryDto(category).getDescription());
        assertEquals(categoryDto.isActive(), converter.toCategoryDto(category).isActive());
    }

    @Test
    void toCategory() {
        CategoryMapper converter = Mappers.getMapper(CategoryMapper.class);
        assertEquals(category.getIdCategory(), converter.toCategory(categoryDto).getIdCategory());
        assertEquals(category.getDescription(), converter.toCategory(categoryDto).getDescription());
        assertEquals(category.getState(), converter.toCategory(categoryDto).getState());
    }
}