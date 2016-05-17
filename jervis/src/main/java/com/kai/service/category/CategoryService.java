package com.kai.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kai.api.model.CategoryDto;
import com.kai.dao.category.ICategoryDao;
import com.kai.domain.Category;
import com.kai.service.BaseService;

@Service
@Transactional
public class CategoryService extends BaseService implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public CategoryDto getById(Long id) {
	Category category = categoryDao.getById(id);

	if (category == null) {
	    return null;
	}

	return toDto(category);
    }

    @Override
    public CategoryDto saveNew(CategoryDto categoryDto) {
	categoryDao.save(toEntity(categoryDto));

	return categoryDto;
    }

    @Override
    public List<CategoryDto> getAll() {
	
	return toDtoList(categoryDao.getAll());
    }

}
