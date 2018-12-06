package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends Model
{
  @Column(name = "age")
  private int age;

  @Column(name = "name")
  private String name;
}
