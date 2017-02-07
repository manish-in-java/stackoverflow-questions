package org.kleber.model.usuario;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends org.kleber.model.Service<Usuario> {

	public UsuarioService() {
		super(Usuario.class);
	}

}
