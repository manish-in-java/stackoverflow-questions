package org.example.web;

import org.example.domain.XnetOrder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/orders")
@RestController
public class XnetController
{
  private static final Map<Long, XnetOrder> ORDERS = new HashMap<>();

  static
  {
    ORDERS.put(1L, new XnetOrder(1L, BigDecimal.ONE));
    ORDERS.put(2L, new XnetOrder(2L, BigDecimal.TEN));
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public void delete(@PathVariable("id") final Long id)
  {
    ORDERS.remove(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public Collection<XnetOrder> list()
  {
    return ORDERS.values();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public XnetOrder get(@PathVariable("id") final Long id)
  {
    return ORDERS.get(id);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
  public void post(@RequestBody final XnetOrder order)
  {
    put(order);
  }

  @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
  public XnetOrder put(@RequestBody final XnetOrder order)
  {
    if (ORDERS.containsKey(order.getID()))
    {
      ORDERS.get(order.getID()).setTotal(order.getTotal());
    }
    else
    {
      ORDERS.put(order.getID(), order);
    }

    return order;
  }
}
