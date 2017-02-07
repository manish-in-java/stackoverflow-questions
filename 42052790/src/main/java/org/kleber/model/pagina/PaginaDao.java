package org.kleber.model.pagina;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class PaginaDao extends Dao<Pagina> {

	public PaginaDao() {
		super(Pagina.class);
	}

}
