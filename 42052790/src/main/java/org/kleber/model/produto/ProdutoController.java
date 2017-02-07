package org.kleber.model.produto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto")
public class ProdutoController extends org.kleber.model.Controller<Produto> {

	public ProdutoController() {
		super(Produto.class);
	}

}
