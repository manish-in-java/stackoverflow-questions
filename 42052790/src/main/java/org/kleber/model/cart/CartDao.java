package org.kleber.model.cart;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao extends Dao<Cart> {

	public CartDao() {
		super(Cart.class);
	}

}
