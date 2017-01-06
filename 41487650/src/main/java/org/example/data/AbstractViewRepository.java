package org.example.data;

import org.example.domain.AbstractView;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface AbstractViewRepository<T extends AbstractView<T>> extends PagingAndSortingRepository<T, Long>
{
}
