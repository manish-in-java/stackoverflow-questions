package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends Model
{
  @Column(length = 100, name = "first_name", nullable = false)
  private String firstName;

  @Column(length = 100, name = "last_name", nullable = false)
  private String lastName;

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setFirstName(final String firstName)
  {
    this.firstName = firstName;
  }

  public void setLastName(final String lastName)
  {
    this.lastName = lastName;
  }
}
