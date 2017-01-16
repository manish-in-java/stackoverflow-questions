package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER", schema = "PUBLIC")
public class Customer
{

  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "NAME")
  private String name;

  public int getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }

    Customer customer = (Customer) o;

    if (id != customer.id)
    {
      return false;
    }
    if (name != null ? !name.equals(customer.name) : customer.name != null)
    {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode()
  {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
