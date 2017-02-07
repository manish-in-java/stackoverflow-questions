package org.kleber.model.autorizacao;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class AutorizacaoDao extends Dao<Autorizacao> {

	public AutorizacaoDao() {
		super(Autorizacao.class);
	}

}
