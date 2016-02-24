package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "child")
public class User
{
  @Column(name = "id", updatable = false)
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "name", unique = true)
  @NotNull
  @Size(max = 100)
  private String name;

  @NotNull
  @OneToOne(cascade = CascadeType.ALL)
  private Role role;

  User()
  {
    super();
  }

  public User(final String name, final Role role)
  {
    this();

    this.name = name;
    this.role = role;
  }

  public Long getID()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public Role getRole()
  {
    return role;
  }
}
