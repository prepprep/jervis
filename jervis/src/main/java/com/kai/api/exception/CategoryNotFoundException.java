package com.kai.api.exception;

public class CategoryNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7230926413882812022L;

    private long categoryId;

    public CategoryNotFoundException(long categoryId) {
	super();
	this.categoryId = categoryId;
    }

    public long getCategoryId() {
	return categoryId;
    }
    
    

}
