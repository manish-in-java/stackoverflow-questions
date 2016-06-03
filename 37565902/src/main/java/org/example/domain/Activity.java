package org.example.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "activity")
public class Activity extends Model
{
  @ManyToMany
  @JoinTable(name = "activity_performance_criterion"
      , joinColumns = @JoinColumn(name = "activity_id")
      , inverseJoinColumns = @JoinColumn(name = "performance_criterion_id"))
  private Set<PerformanceCriterion> performanceCriteria;
}
