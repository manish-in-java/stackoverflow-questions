package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Service extends Model
{
  @JoinColumn(name = "auto_service_id", nullable = false)
  @ManyToOne
  private AutoService autoService;

  @Column(name = "category", nullable = false)
  private String category;

  Service()
  {
    super();
  }

  public Service(final AutoService autoService, final String category)
  {
    this.autoService = autoService;
    this.category = category;
  }

  public AutoService getAutoService()
  {
    return autoService;
  }

  public String getCategory()
  {
    return category;
  }
}
