package org.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category extends DescribableModel<CategoryDetail>
{
  private String name;

  public Category(String name, CategoryDetail detail)
  {
    super(detail);

    this.name = name;
  }

  public String getName()
  {
    return name;
  }
}
