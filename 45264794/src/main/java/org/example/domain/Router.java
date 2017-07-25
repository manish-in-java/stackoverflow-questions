package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Router extends Model
{
  @Column(name = "ip_address")
  private String ipAddress;

  @Column(name = "name")
  private String name;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "router")
  private Set<RouterDetail> routerDetails;
}
