package com.kai.dao.customer;

import com.kai.dao.IHibernateDao;
import com.kai.domain.Customer;

public interface ICustomerDao extends IHibernateDao<Customer> {
    
    public Customer getById(Long id);

}
