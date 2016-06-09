package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "board")
public class Board extends Model
{
  public static final int AFK         = 2;
  public static final int COMPLETED   = 3;
  public static final int IN_PROGRESS = 1;

  @Column(name = "status", nullable = false)
  private int status = IN_PROGRESS;

  public int getStatus()
  {
    return status;
  }

  public void setStatus(final int status)
  {
    this.status = status;
  }
}
