package com.kai.dao.customeritem;

import com.kai.dao.IHibernateDao;
import com.kai.domain.CustomerItem;

public interface ICustomerItemDao extends IHibernateDao<CustomerItem> {
    
    CustomerItem getById(Long id);

}
