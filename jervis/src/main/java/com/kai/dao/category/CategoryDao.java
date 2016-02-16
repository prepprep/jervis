package com.kai.dao.category;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.kai.dao.HibernateDao;
import com.kai.domain.Category;

@Repository
public class CategoryDao extends HibernateDao<Category> implements ICategoryDao {

    @Override
    public Category getById(Long id) {
	String stmt = "select c from Category c where c.id = :id";
	Query query = getSession().createQuery(stmt);
	query.setParameter("id", id);
	return (Category) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> getAll() {
	// TODO Auto-generated method stub
	String stmt = "select c from Category c";
	Query query = getSession().createQuery(stmt);
	return query.list();
    }

}
