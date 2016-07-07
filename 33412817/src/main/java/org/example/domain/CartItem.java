package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem extends Model
{
  @JoinColumn(name = "cart_id", updatable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Cart cart;

  @JoinColumn(name = "product_id", updatable = false)
  @ManyToOne(fetch = FetchType.LAZY)
  private Product product;

  @Column(name = "quantity")
  private long quantity = 0L;

  @JoinColumn(name = "stock_id", updatable = false)
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
  private Stock stock;

  CartItem()
  {
    super();
  }

  public CartItem(final Cart cart, final Product product, final Stock stock)
  {
    this.cart = cart;
    this.product = product;
    this.stock = stock;
  }

  public long getQuantity()
  {
    return quantity;
  }

  public void setQuantity(final long quantity)
  {
    final long delta = Math.max(0L, quantity) - this.quantity;

    this.quantity += delta;
    this.stock.setQuantity(this.stock.getQuantity() - delta);

    if (quantity < 1)
    {
      cart.removeItem(this);
    }
  }
}
