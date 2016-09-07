package org.example.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "algo")
public class Algo extends Model
{
  @Fetch(FetchMode.SELECT)
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "algo", orphanRemoval = true)
  private List<Rec> recs;

  public void addRec(final Rec rec)
  {
    if (rec != null)
    {
      if (recs == null)
      {
        recs = new ArrayList<>();
      }

      rec.setAlgo(this);

      recs.add(rec);
    }
  }

  public List<Rec> getRecs()
  {
    return recs != null ? Collections.unmodifiableList(recs) : Collections.emptyList();
  }
}
