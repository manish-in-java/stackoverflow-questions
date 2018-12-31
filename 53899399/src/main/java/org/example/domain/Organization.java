package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "organization")
public class Organization extends Model
{
  @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT), insertable = false, name = "org_name", referencedColumnName = "org_name", updatable = false)
  @ManyToOne(cascade = CascadeType.ALL)
  private Grant grant;

  @Column(name = "org_name", nullable = false)
  private String name;

  Organization()
  {
    super();
  }

  public Organization(final String name)
  {
    this();

    this.name = name;
  }

  public Grant getGrant()
  {
    return grant;
  }

  public String getName()
  {
    return name;
  }

  void setGrant(final Grant grant)
  {
    this.grant = grant;
  }
}
