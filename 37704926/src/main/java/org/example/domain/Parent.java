package org.example.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "parent")
public class Parent extends Model
{
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", orphanRemoval = true)
  private Set<Child> children;

  public void addChild(final Child child)
  {
    if (child != null)
    {
      if (children == null)
      {
        children = new HashSet<>();
      }

      child.setParent(this);

      children.add(child);
    }
  }

  public Set<Child> getChildren()
  {
    return children != null ? Collections.unmodifiableSet(children) : Collections.emptySet();
  }

  void removeChild(final Child child)
  {
    if (child != null && children != null)
    {
      children.remove(child);
    }
  }
}
