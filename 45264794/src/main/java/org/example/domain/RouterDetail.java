package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RouterDetail extends Model
{
  @Column(name = "object_type")
  private Character objectType;

  @JoinColumn(name = "ip_address", referencedColumnName = "ip_address")
  @ManyToOne
  private Router router;
}
