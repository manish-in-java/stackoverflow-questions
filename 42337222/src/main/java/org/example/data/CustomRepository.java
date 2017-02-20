package org.example.data;

import java.io.Serializable;

public interface CustomRepository<T, ID extends Serializable>
{
  void customMethod();
}
