package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public class Gender
{
  @Id
  @Column(name = "gender_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "gender_name")
  private String name;
}
