package org.kleber.model;

import java.util.List;

public abstract class Dao<E> {
	protected Class<E> clazz;
	
	public Dao(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	public void insert(E object) {
		//
	}
	
	public void update(E object) {
		//
	}
	
	public void delete(E object) {
		//
	}
	
	public List<E> select(String orderby, String groupby) {
		return null;
	}
	
	public E select(String id) {
		return null;
	}
	
	public E findBy(String key, String value) {
		return null;
	}
	
	public String getName() {
		return clazz.getSimpleName().toLowerCase();
	}
}
