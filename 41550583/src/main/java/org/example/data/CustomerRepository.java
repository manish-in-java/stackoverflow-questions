package org.example.data;

import org.example.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dims on 13.01.2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
