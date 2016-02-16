package com.kai.dao.item;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.kai.dao.HibernateDao;
import com.kai.domain.Item;

@Repository
public class ItemDao extends HibernateDao<Item> implements IItemDao {
    
    @Override
    public Item getById(Long id) {
	String stmt = "select i from Item i where id = :id";
	Query query = getSession().createQuery(stmt);
	query.setParameter("id", id);
	return (Item) query.uniqueResult();
    }

}
