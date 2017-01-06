package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Set;

@MappedSuperclass
public abstract class AbstractView<T extends HierarchicalEntity<T>> implements HierarchicalEntity<T>
{
  @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
  private Set<T> children;

  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @JoinColumn(name = "parent_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private T parent;

  @Override
  public Set<T> getChildren()
  {
    return children;
  }

  public Long getId()
  {
    return id;
  }

  @Override
  public T getParent()
  {
    return parent;
  }
}
