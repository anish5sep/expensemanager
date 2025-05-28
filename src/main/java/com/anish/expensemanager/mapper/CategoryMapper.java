package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.CategoryDto;
import com.anish.expensemanager.entities.Category;

public class CategoryMapper {

    private CategoryMapper() {}

    public static CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public static Category toEntity(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
