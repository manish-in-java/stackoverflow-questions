package org.example.data;

import org.bson.types.ObjectId;
import org.example.domain.ProductDetail;
import org.springframework.data.repository.CrudRepository;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, ObjectId>
{
}
