package org.example.data;

import org.example.domain.Modelo;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface ModeloRepository<T extends Modelo> extends PagingAndSortingRepository<T, Long>
{
}
