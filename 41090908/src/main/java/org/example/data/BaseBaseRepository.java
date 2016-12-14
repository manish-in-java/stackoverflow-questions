package org.example.data;

import org.example.domain.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseBaseRepository<T extends Base> extends JpaRepository<T, Long>
{
}
