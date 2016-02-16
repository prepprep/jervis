package com.kai.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

import com.kai.domain.enums.ItemStatus;

@Entity
public class Item extends AbstractEntity {

    private static final long serialVersionUID = 1500645436457609798L;

    private String description;

    @Size(max = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus;

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public ItemStatus getItemStatus() {
	return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
	this.itemStatus = itemStatus;
    }

}
