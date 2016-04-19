package org.example.transfer;

public class CompanySummary
{
  private final Long   id;
  private final String name;

  public CompanySummary(final Long id, final String name)
  {
    this.id = id;
    this.name = name;
  }

  public Long getID()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }
}
