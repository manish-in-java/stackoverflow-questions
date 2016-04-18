package org.example.data;

import org.example.domain.Posting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostingRepository extends CrudRepository<Posting, Long>
{
  @Query("select"
      + "  t "
      + "from "
      + "  Posting t "
      + "where "
      + "  (t.plan is NULL or t.plan = '') "
      + "and t.date between ?1 and ?2")
  List<Posting> findOrphaned(LocalDateTime fromDate, LocalDateTime toDate);
}
