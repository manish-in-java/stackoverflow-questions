package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rec")
public class Rec extends Model
{
  @JoinColumn(name = "algo_id", nullable = false)
  @ManyToOne
  private Algo algo;

  public Algo getAlgo()
  {
    return algo;
  }

  void setAlgo(final Algo algo)
  {
    this.algo = algo;
  }
}
