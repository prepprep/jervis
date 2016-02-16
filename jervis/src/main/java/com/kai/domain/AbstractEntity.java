package com.kai.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 * @author Kai
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1801341563292719903L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
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

    @PrePersist
    public void setDateCreated() {
	this.dateCreated = LocalDateTime.now();
    }

}
