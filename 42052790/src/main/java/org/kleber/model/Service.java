package org.kleber.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Service<E> {
	@Autowired
	protected Dao<E> dao;
	
	protected Class<E> clazz;
	
	public Service(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	public void insert(E object) {
		dao.insert(object);
	}
	
	public void update(E object) {
		dao.update(object);
	}
	
	public void delete(E object) {
		dao.delete(object);
	}
	
	public List<E> select(String orderby, String groupby) {
		return dao.select(orderby, groupby);
	}
	
	public E newObject() throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}
	
	public E getObject(String id) {
		return dao.select(id);
	}
	
	public String getName() {
		return clazz.getSimpleName().toLowerCase();
	}
}
