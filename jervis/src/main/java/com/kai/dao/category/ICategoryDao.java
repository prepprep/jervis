package com.kai.dao.category;

import java.util.List;

import com.kai.dao.IHibernateDao;
import com.kai.domain.Category;


public interface ICategoryDao extends IHibernateDao<Category> {
    
    Category getById(Long id);
    
    List<Category> getAll();

}
