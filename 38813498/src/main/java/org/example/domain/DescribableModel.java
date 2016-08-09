package org.example.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;

abstract class DescribableModel<Detail extends Model> extends Model
{
  @DBRef
  private Detail detail;

  protected DescribableModel(Detail detail)
  {
    this.detail = detail;
  }

  public Detail getDetail()
  {
    return detail;
  }
}
