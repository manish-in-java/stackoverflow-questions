package org.example.data;

import org.bson.types.ObjectId;
import org.example.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, ObjectId>
{
}
