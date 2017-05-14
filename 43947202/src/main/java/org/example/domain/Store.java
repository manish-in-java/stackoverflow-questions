package org.example.domain;

import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@QueryEntity
public class Store extends Model
{
  @Column(length = 100, name = "name", nullable = false)
  private String name;

  @JoinTable(inverseJoinColumns = @JoinColumn(name = "product_id"), joinColumns = @JoinColumn(name = "store_id"), name = "store_product")
  @ManyToMany
  private Set<Product> products;

  public String getName()
  {
    return name;
  }

  public Set<Product> getProducts()
  {
    return products;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setProducts(Set<Product> products)
  {
    this.products = products;
  }
}
