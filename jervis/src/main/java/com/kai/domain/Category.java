package com.kai.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Category extends AbstractEntity {

    private static final long serialVersionUID = -5133542512660262966L;

    @Size(max = 50)
    private String name;

    @Size(max = 20)
    private String type;

    @Size(max = 50)
    private String path;

    @ManyToOne
    private Category parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Category> subCategories;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }

    public Category getParent() {
	return parent;
    }

    public void setParent(Category parent) {
	this.parent = parent;
    }

    public List<Category> getSubCategories() {
	return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
	this.subCategories = subCategories;
    }

}
