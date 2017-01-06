package org.example.domain;

import java.util.Collection;

public interface HierarchicalEntity<T extends HierarchicalEntity<T>>
{
  Collection<? extends T> getChildren();

  T getParent();
}
