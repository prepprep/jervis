package com.kai.dao;

import java.util.List;

public interface IHibernateDao<T> {

    T getById(Long id);

    T saveNew(T entity);

    T save(T entity);

    void flush();

    void delete(T entity);

    T merge(T entity);

    List<T> getAll();

}
