package org.example.data;

import org.example.domain.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends ModelRepository<Task>
{
  @Modifying
  @Query("delete from Task t where t.status = ?1")
  @Transactional
  int deleteByStatus(int status);
}
