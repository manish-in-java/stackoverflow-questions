package org.kleber.settings.geral;

import org.kleber.settings.Property;

public class Geral extends Property {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1336603477955595950L;
	
	private String autor;
	
	private String email;
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
