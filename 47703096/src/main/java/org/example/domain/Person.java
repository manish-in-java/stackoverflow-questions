package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person
{
  @Column(length = 50, name = "first_name")
  private String firstName;

  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @SuppressWarnings("unused")
  private Long id;

  @Column(length = 50, name = "last_name")
  private String lastName;

  public String getFirstName()
  {
    return firstName;
  }

  public Long getID()
  {
    return id;
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
