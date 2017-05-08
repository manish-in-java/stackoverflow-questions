package org.example.data;

import org.example.domain.Task;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends ModelRepository<Task>
{
  @Transactional
  Long deleteByStatus(int status);
}
