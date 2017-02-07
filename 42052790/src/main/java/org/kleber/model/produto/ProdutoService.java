package org.kleber.model.produto;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends org.kleber.model.Service<Produto> {

	public ProdutoService() {
		super(Produto.class);
	}

}
