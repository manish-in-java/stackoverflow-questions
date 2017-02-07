package org.kleber.model.texto;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class TextoDao extends Dao<Texto> {

	public TextoDao() {
		super(Texto.class);
	}

}
