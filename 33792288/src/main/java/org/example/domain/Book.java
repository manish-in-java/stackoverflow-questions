package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "description", length = 4000)
  private String description;

  @Column(name = "title")
  private String title;

  Book()
  {
    super();
  }

  public Book(final String title, final String description)
  {
    this.description = description;
    this.title = title;
  }

  public String getDescription()
  {
    return description;
  }

  public Long getID()
  {
    return id;
  }

  public String getTitle()
  {
    return title;
  }
}
