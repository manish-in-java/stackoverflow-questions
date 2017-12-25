package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "application")
public class Application extends Model
{
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "application")
  private Set<Tenant> tenants;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<ApplicationUser> users;

  public void addTenant(final Tenant tenant)
  {
    if (tenants == null)
    {
      tenants = new HashSet<>();
    }

    tenants.add(tenant);

    tenant.setApplication(this);
  }

  public void addUser(final ApplicationUser user)
  {
    if (users == null)
    {
      users = new HashSet<>();
    }

    users.add(user);
  }

  public Set<Tenant> getTenants()
  {
    return tenants;
  }

  public Set<ApplicationUser> getUsers()
  {
    return users;
  }
}
