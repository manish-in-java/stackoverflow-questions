package com.mapping.jpa.model;

import javax.persistence.*;

@Entity
public class Buyer extends User {

	@OneToOne
	@MapsId
	//@JoinColumn(nullable=true)
	private ExternalAccount externalAccount;

	public ExternalAccount getExternalAccount() {
		return externalAccount;
	}

	public void setExternalAccount(ExternalAccount externalAccount) {
		this.externalAccount = externalAccount;
	}

}
