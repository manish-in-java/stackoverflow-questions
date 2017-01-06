package org.example.data;

import org.example.domain.Cart;

import java.util.List;

public interface CartRepository extends ModelRepository<Cart>
{
  List<Cart> findAllByCustomerCityName(String city);
}
