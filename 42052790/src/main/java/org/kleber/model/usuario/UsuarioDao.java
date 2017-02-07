package org.kleber.model.usuario;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao extends Dao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

}
