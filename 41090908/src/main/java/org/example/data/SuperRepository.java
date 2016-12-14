package org.example.data;

import org.example.domain.Super;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SuperRepository<T extends Super> extends BaseBaseRepository<T>
{
}
