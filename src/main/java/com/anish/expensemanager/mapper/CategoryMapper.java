package com.anish.expensemanager.mapper;

import com.anish.expensemanager.dto.CategoryDTO;
import com.anish.expensemanager.entities.Category;

public class CategoryMapper {

    private CategoryMapper() {}

    public static CategoryDTO toDto(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public static Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
