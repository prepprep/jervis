package com.kai.dao.item;

import com.kai.dao.IHibernateDao;
import com.kai.domain.Item;

public interface IItemDao extends IHibernateDao<Item> {

    Item getById(Long id);
}
