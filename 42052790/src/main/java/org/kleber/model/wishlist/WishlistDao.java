package org.kleber.model.wishlist;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class WishlistDao extends Dao<Wishlist> {

	public WishlistDao() {
		super(Wishlist.class);
	}

}
