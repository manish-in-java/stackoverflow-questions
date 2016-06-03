package org.example.data;

import org.example.domain.Achievement;
import org.example.domain.ChecklistItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AchievementRepository extends CrudRepository<AchievementRepository, Long>
{
  @Query("SELECT "
      + "  a "
      + "FROM "
      + "  Achievement              a "
      + "  , Activity               v "
      + "  , ChecklistItem          i "
      + "WHERE "
      + "  i                        = ?1 "
      + "AND i.a                    = v "
      + "AND a.performanceCriterion MEMBER OF v.performanceCriteria "
      + "AND i                      MEMBER OF a.checklistItems")
  List<Achievement> findAllByChecklistItem(ChecklistItem item);
}
