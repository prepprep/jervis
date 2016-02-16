package com.kai.api.model;

import java.time.LocalDateTime;

public abstract class AbstractDto {

    private Long id;

    private LocalDateTime dateCreated;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public LocalDateTime getDateCreated() {
	return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
	this.dateCreated = dateCreated;
    }

}
