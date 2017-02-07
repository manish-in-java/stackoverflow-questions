package org.kleber.model.usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.kleber.model.Model;
import org.kleber.model.autorizacao.Autorizacao;
import org.kleber.model.cart.Cart;
import org.kleber.model.credencial.Credencial;
import org.kleber.model.order.Orders;
import org.kleber.model.wishlist.Wishlist;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario extends Model implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String login;
	
	@Column
	private String senha;
	
	@Column
	private String nome;
	
	@Column
	private String sobrenome;
	
	@Column
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Cart cesta;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Wishlist> listas;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Orders> pedidos;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Credencial> credenciais;

	@Override
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getNome() + " " + getSobrenome();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Credencial> getCredenciais() {
		return credenciais;
	}

	public void setCredenciais(List<Credencial> credenciais) {
		this.credenciais = credenciais;
	}

	public Cart getCesta() {
		return cesta;
	}

	public void setCesta(Cart cesta) {
		this.cesta = cesta;
	}

	public List<Wishlist> getListas() {
		return listas;
	}

	public void setListas(List<Wishlist> listas) {
		this.listas = listas;
	}

	public List<Orders> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Orders> pedidos) {
		this.pedidos = pedidos;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<Autorizacao> authorities = new ArrayList<Autorizacao>();
		for(Credencial c : credenciais)
			authorities.addAll(c.getAutorizacoes());
		return authorities;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
