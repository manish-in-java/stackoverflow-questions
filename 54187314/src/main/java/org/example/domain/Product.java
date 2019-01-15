package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends Model
{
  @Lob
  private String category;
  @Lob
  private String customerNumber;
  @Lob
  private String name;
}
