package org.example.data;

import org.example.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExampleRepository extends PagingAndSortingRepository<Example, Long>
{
  Page<String> findDistinctNameByCatId(Long catId, Pageable page);
}
