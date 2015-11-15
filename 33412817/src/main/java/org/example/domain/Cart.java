package org.example.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart extends Model
{
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cart", orphanRemoval = true)
  private List<CartItem> items = null;

  public void addItem(final CartItem item)
  {
    if (items == null)
    {
      items = new ArrayList<>();
    }
    items.add(item);
  }

  void removeItem(final CartItem item)
  {
    items.remove(item);
  }
}
