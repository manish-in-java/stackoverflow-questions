package org.example.domain;

import org.bson.types.ObjectId;

import java.io.Serializable;

abstract class Model implements Serializable
{
  private ObjectId id;

  public ObjectId getID()
  {
    return id;
  }
}
