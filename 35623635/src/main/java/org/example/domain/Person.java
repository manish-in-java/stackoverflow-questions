package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person
{
  @Column(name = "id", updatable = false)
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "first_name")
  @NotNull
  @Size(max = 50)
  private String firstName;

  @Column(name = "last_name")
  @NotNull
  @Size(max = 50)
  private String lastName;

  Person()
  {
    super();
  }

  public Person(final String firstName, final String lastName)
  {
    this();

    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getID()
  {
    return id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }
}
