package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Map;

@Entity
@Table(name = "foo")
public class Foo extends Model
{
  private transient Collection<Map<String, Integer>> bar;

  @Transient
  public Collection<Map<String, Integer>> getBar()
  {
    return bar;
  }

  public void setBar(Collection<Map<String, Integer>> bar)
  {
    this.bar = bar;
  }
}
