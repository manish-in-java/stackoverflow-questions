package org.example.data;

import org.example.domain.BaseImpl;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BaseRepositoryImpl extends BaseRepository<BaseImpl>
{
}
