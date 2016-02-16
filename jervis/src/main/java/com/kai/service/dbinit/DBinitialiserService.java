package com.kai.service.dbinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kai.dao.category.ICategoryDao;
import com.kai.dao.customer.ICustomerDao;
import com.kai.dao.customeritem.ICustomerItemDao;
import com.kai.dao.item.IItemDao;
import com.kai.domain.Address;
import com.kai.domain.Category;
import com.kai.domain.Customer;
import com.kai.domain.CustomerItem;
import com.kai.domain.Item;
import com.kai.domain.enums.ItemStatus;

@Service
@Transactional
public class DBinitialiserService implements IDBinitialiserService {

    @Autowired
    private ICategoryDao categoryDao;

    @Autowired
    private IItemDao itemDao;

    @Autowired
    private ICustomerDao customerDao;
    
    @Autowired
    private ICustomerItemDao customerItemDao;

    @Override
    public void initDb() {
	saveCateories();
	saveItems();
	saveCustomer();
	saveCustomerItem();
    }

    // create customer
    private void saveCustomer() {
	for (int i = 0; i < 5; i++)
	    customerDao.saveNew(customer());
    }

    private Customer customer() {
	Customer customer = new Customer();
	Address address = new Address();
	address.setAddressLine1(DbFiller.getAddressLine());
	address.setAddressLine2(DbFiller.getAddressLine());
	address.setAddressLine3(DbFiller.getAddressLine());
	address.setCity(DbFiller.getCity());
	address.setCounty(DbFiller.getCounty());
	address.setCountry(DbFiller.getCountry());

	customer.setAddress(address);
	customer.setFirstName(DbFiller.getFirstLastName());
	customer.setLastName(DbFiller.getFirstLastName());
	customer.setPassword(DbFiller.getPassword());
	customer.setPhone(DbFiller.getPhone());
	customer.setEmail(DbFiller.getEmail());

	return customer;
    }

    // create customer_item
    private void saveCustomerItem() {
	customerItemDao.saveNew(customerItem());
    }

    private CustomerItem customerItem() {
	CustomerItem customerItem = new CustomerItem();
	customerItem.setCustomer(customerDao.getById(1L));
	customerItem.setItem(itemDao.getById(1L));
	return customerItem;
    }

    // create items
    private void saveItems() {
	for (int i = 0; i < 5; i++)
	    itemDao.saveNew(item());
    }

    private Item item() {
	Item item = new Item();
	item.setName(DbFiller.getItemName());
	item.setItemStatus(getEnum(ItemStatus.values()));
	return item;
    }

    // create categories
    private void saveCateories() {
	for (int i = 0; i < 5; i++)
	    categoryDao.saveNew(category(DbFiller.getCategoryName(), DbFiller.getType()));
    }

    private Category category(String name, String type) {
	Category category = new Category();
	category.setName(name);
	category.setType(type);
	return category;
    }

    private <T extends Enum<T>> T getEnum(T[] values) {
	int index = (int) (Math.random() * values.length);
	return values[index];
    }

}
