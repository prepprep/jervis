package com.kai.service.category;

import java.util.List;

import com.kai.api.model.CategoryDto;

public interface ICategoryService {
    
    CategoryDto getById(Long id);
    
    CategoryDto saveNew(CategoryDto categoryDto);
    
    List<CategoryDto> getAll();

}
