package com.mapping.jpa.model;

import javax.persistence.*;

@Entity
public class ExternalAccount {

	@Id
	@PrimaryKeyJoinColumn
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
