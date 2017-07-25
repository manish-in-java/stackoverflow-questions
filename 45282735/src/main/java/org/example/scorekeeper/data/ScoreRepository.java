package org.example.scorekeeper.data;

import org.example.scorekeeper.domain.Score;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, Long>
{
  List<Score> findBySite(String site);
}
