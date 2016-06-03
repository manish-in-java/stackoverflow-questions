package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "achievement")
public class Achievement extends Model
{
  @ManyToOne
  @JoinColumn(name = "performance_criterion_id")
  private PerformanceCriterion performanceCriterion;

  @ManyToMany
  @JoinTable(name = "achievement_checklist_item"
      , joinColumns = @JoinColumn(name = "achievement_id")
      , inverseJoinColumns = @JoinColumn(name = "checklist_item_id"))
  private Set<ChecklistItem> checklistItems = new HashSet<>();
}
