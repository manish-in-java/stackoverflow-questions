package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Equipment extends Model
{
  @Column(name = "make", nullable = false)
  private String make;

  @Column(name = "model", nullable = false)
  private String model;

  @Column(name = "serialNumber", nullable = false)
  private String serialNumber;

  Equipment()
  {
    super();
  }

  protected Equipment(final String serialNumber, final String make, final String model)
  {
    this();

    this.make = make;
    this.model = model;
    this.serialNumber = serialNumber;
  }

  public String getMake()
  {
    return make;
  }

  public String getModel()
  {
    return model;
  }

  public String getSerialNumber()
  {
    return serialNumber;
  }
}
