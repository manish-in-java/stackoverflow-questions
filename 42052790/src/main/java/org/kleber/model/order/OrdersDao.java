package org.kleber.model.order;

import org.kleber.model.Dao;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDao extends Dao<Orders> {

	public OrdersDao() {
		super(Orders.class);
	}

}
