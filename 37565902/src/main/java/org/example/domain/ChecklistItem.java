package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "checklist_item")
public class ChecklistItem extends Model
{
  @ManyToOne
  @JoinColumn(name = "activity_id")
  private Activity activity;
}
