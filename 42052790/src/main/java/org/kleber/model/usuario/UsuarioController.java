package org.kleber.model.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController extends org.kleber.model.Controller<Usuario> {

	public UsuarioController() {
		super(Usuario.class);
	}

}
