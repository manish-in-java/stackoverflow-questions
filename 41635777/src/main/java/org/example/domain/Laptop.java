package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop extends Model
{
  @Column(name = "serial_number", nullable = false, unique = true)
  private String serialNumber;

  Laptop()
  {
    super();
  }

  public Laptop(final String serialNumber)
  {
    this.serialNumber = serialNumber;
  }

  public String getSerialNumber()
  {
    return serialNumber;
  }
}
