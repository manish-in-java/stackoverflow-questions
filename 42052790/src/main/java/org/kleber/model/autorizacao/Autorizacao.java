package org.kleber.model.autorizacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.kleber.model.Model;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Autorizacao extends Model implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAuthority() {
		return nome;
	}

}
