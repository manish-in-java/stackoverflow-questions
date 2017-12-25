package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class News extends Model
{
  @OneToOne
  private Photo photo;
}
