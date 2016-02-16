package com.kai.dao;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public abstract class HibernateDao<T> implements IHibernateDao<T> {

    private Class<T> entityClass;

    @Resource
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public HibernateDao() {
	this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
		.getActualTypeArguments()[0];
    }

    protected Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    @Override
    public T save(T entity) {
	getSession().saveOrUpdate(entity);
	return entity;
    }

    @Override
    public T saveNew(T entity) {
	getSession().save(entity);
	return entity;
    }

    @Override
    public T getById(Long id) {
	return (T) getSession().get(entityClass, id);
    }

    @Override
    public void flush() {
	getSession().flush();
    }

    @Override
    public void delete(T entity) {
	getSession().delete(entity);
    }

    @Override
    public T merge(T entity) {
	getSession().merge(entity);
	return entity;
    }

    @Override
    public List<T> getAll() {
	// TODO Not implemented
	return null;
    }

}
