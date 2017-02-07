package org.kleber.model.pagina;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pagina")
public class PaginaController extends org.kleber.model.Controller<Pagina> {

	public PaginaController() {
		super(Pagina.class);
	}

}
