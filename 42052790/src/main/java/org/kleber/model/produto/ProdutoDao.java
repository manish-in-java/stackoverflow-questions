package org.kleber.model.produto;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDao extends Dao<Produto> {

	public ProdutoDao() {
		super(Produto.class);
	}

}
