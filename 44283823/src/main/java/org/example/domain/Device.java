package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "device")
public class Device
{
  private UUID id;

  @Column(name = "id")
  @Id
  public UUID getId()
  {
    return id;
  }

  public void setId(final UUID id)
  {
    this.id = id;
  }
}
