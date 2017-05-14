package org.example.data;

import org.example.domain.Store;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface StoreRepository extends ModelRepository<Store>
    , QueryDslPredicateExecutor<Store>
{
}
