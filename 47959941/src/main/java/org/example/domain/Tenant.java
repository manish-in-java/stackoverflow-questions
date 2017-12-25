package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tenant")
public class Tenant extends Model
{
  @JoinColumn(name = "application_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Application application;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<TenantUser> users;

  public void addUser(final TenantUser user)
  {
    if (users == null)
    {
      users = new HashSet<>();
    }

    users.add(user);
  }

  public Application getApplication()
  {
    return application;
  }

  public Set<TenantUser> getUsers()
  {
    return users;
  }

  void setApplication(final Application application)
  {
    this.application = application;
  }
}
