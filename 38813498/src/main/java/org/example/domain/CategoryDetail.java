package org.example.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CategoryDetail extends Model
{
  private String description;

  public CategoryDetail(String description)
  {
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }
}
