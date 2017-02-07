package org.kleber.settings;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class PropertyService<E extends Property> {
	
	@Autowired
	protected PropertyDao<E> dao;
	
	protected Class<E> clazz;
	
	public PropertyService(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	public E get() throws ClassNotFoundException, IOException {
		return dao.get();
	}
	
	public void set(E object) throws IOException {
		dao.set(object);
	}

}
