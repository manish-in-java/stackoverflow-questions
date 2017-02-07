package org.kleber.model.arquivo;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class ArquivoDao extends Dao<Arquivo> {

	public ArquivoDao() {
		super(Arquivo.class);
	}

}
