package org.example.data;

import org.bson.types.ObjectId;
import org.example.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, ObjectId>
{
}
