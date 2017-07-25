package org.example.scorekeeper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Score
{
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long   id;
  private String site;
  private double value;

  Score()
  {
  }

  public Score(String site, double value)
  {
    this.site = site;
    this.value = value;
  }

  @Override
  public String toString()
  {
    return String.format(
        "Customer[id=%d, siteName='%s', score='%d']",
        id, site, value);
  }
}
