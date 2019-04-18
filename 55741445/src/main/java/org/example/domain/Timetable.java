package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Timetable
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "roster_date", nullable = false)
  private LocalDate rosterDate;

  Timetable()
  {
    super();
  }

  public Timetable(final String name, final LocalDate rosterDate)
  {
    this();

    this.name = name;
    this.rosterDate = rosterDate;
  }

  public String getName()
  {
    return name;
  }

  public LocalDate getRosterDate()
  {
    return rosterDate;
  }
}
