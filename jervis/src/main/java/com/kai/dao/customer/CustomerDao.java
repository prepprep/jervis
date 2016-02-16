package com.kai.dao.customer;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.kai.dao.HibernateDao;
import com.kai.domain.Customer;

@Repository
public class CustomerDao extends HibernateDao<Customer> implements ICustomerDao {

    @Override
    public Customer getById(Long id) {
	String stmt = "select c from Customer c where c.id = :id";
	Query query = getSession().createQuery(stmt);
	query.setParameter("id", id);
	return (Customer) query.uniqueResult();
    }
}
