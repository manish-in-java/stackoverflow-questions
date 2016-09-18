package org.example.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends Model
{
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
  private List<Item> items;

  public void addItem(final Item item)
  {
    if (item != null)
    {
      if (items == null)
      {
        items = new ArrayList<>();
      }

      item.setUser(this);

      items.add(item);
    }
  }

  public List<Item> getItems()
  {
    return items != null ? Collections.unmodifiableList(items) : Collections.emptyList();
  }
}
