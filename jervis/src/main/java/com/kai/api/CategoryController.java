package com.kai.api;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kai.api.error.APIError;
import com.kai.api.exception.CategoryNotFoundException;
import com.kai.api.model.CategoryDto;
import com.kai.service.category.ICategoryService;

@RestController
public class CategoryController extends BaseController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(path = "/category/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public CategoryDto getSpecificCategory(@PathVariable Long id) {
	CategoryDto categoryDto = categoryService.getById(id);

	if (categoryDto == null) {
	    throw new CategoryNotFoundException(id);
	}
	return categoryDto;
    }

    @RequestMapping(path = "/category/new", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
	CategoryDto dto = categoryService.saveNew(categoryDto);
	HttpHeaders headers = new HttpHeaders();
	URI locationUri = URI.create("http://localhost:9090/category/" + dto.getId());
	headers.setLocation(locationUri);
	ResponseEntity<CategoryDto> responseEntity = new ResponseEntity<CategoryDto>(dto, headers, HttpStatus.CREATED);
	return responseEntity;
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError categoryNotFound(CategoryNotFoundException e) {
	long categoryId = e.getCategoryId();
	return new APIError(4, "category [" + categoryId + "] not found");
    }

}
