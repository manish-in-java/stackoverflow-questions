package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AutoService extends Model
{
  @Column(name = "service_name", nullable = false)
  private String serviceName;

  AutoService()
  {
    super();
  }

  public AutoService(final String serviceName)
  {
    this.serviceName = serviceName;
  }

  public String getServiceName()
  {
    return serviceName;
  }
}
