package org.example.data;

import org.bson.types.ObjectId;
import org.example.domain.CategoryDetail;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDetailRepository extends CrudRepository<CategoryDetail, ObjectId>
{
}
