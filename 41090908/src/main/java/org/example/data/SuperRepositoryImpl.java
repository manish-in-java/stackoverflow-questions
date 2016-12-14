package org.example.data;

import org.example.domain.SuperImpl;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SuperRepositoryImpl extends SuperRepository<SuperImpl>
{
}
