package com.kai.service.category;

import com.kai.api.model.CategoryDto;

public interface ICategoryService {
    
    CategoryDto getById(Long id);
    
    CategoryDto saveNew(CategoryDto categoryDto);

}
