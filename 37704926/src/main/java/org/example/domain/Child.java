package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "child")
public class Child extends Model
{
  @JoinColumn(name = "parent_id", nullable = false)
  @ManyToOne
  private Parent parent;

  public Parent getParent()
  {
    return parent;
  }

  void setParent(final Parent parent)
  {
    if (this.parent != null)
    {
      this.parent.removeChild(this);
    }

    this.parent = parent;
  }
}
