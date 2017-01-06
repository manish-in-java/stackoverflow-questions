package org.example.data;

import org.example.domain.Customer;

public interface CustomerRepository extends ModelRepository<Customer>
{
  Customer findByName(String name);
}
