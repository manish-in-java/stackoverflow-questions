package org.example.data;

import org.example.domain.Base;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Base> extends BaseBaseRepository<T>
{
}
