package org.kleber.model.credencial;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class CredencialDao extends Dao<Credencial> {

	public CredencialDao() {
		super(Credencial.class);
	}

}
