package org.example.domain;

import com.univocity.parsers.annotations.Parsed;

public class Person
{
  @Parsed(field = "First name")
  private String firstName;
  @Parsed(field = "Last name")
  private String lastName;

  public Person()
  {
    super();
  }

  public Person(final String firstName, final String lastName)
  {
    this();

    this.firstName = firstName;
    this.lastName = lastName;
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
