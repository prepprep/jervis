package com.kai.dao.customeritem;

import org.springframework.stereotype.Repository;

import com.kai.dao.HibernateDao;
import com.kai.domain.CustomerItem;

@Repository
public class CustomerItemDao extends HibernateDao<CustomerItem> implements ICustomerItemDao {

}
