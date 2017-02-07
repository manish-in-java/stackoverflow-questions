package org.kleber.model.categoria;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriaDao extends Dao<Categoria> {

	public CategoriaDao() {
		super(Categoria.class);
	}

}
