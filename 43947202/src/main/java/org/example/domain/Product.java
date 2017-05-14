package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@QueryEntity
public class Product extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  @JoinTable(inverseJoinColumns = @JoinColumn(name = "store_id"), joinColumns = @JoinColumn(name = "product_id"), name = "store_product")
  @ManyToMany
  private Set<Store> stores;

  public String getName()
  {
    return name;
  }

  public Set<Store> getStores()
  {
    return stores;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setStores(Set<Store> stores)
  {
    this.stores = stores;
  }
}
