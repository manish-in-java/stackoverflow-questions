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
  private Long quantity;

  @JoinColumn(name = "stock_id", updatable = false)
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Stock stock;

  public void setQuantity(Long quantity)
  {
    final Long delta = this.quantity - Math.max(0L, quantity);

    this.quantity += delta;
    this.stock.setQuantity(this.stock.getQuantity() - delta);

    if (quantity < 1)
    {
      cart.removeItem(this);
    }
  }
}
