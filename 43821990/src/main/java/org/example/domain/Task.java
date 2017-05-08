package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Task extends Model
{
  @Column(name = "status", nullable = false)
  private int status;

  Task()
  {
    super();
  }

  public Task(final int status)
  {
    this();

    this.status = status;
  }

  public int getStatus()
  {
    return status;
  }
}
