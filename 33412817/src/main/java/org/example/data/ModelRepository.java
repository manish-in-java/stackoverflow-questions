package org.example.data;

import org.example.domain.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository<T extends Model> extends CrudRepository<T, Long>
{
}
