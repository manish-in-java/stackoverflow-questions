package org.example.data;

import org.example.domain.Foo;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;

@Lazy
public interface FooRepository extends CrudRepository<Foo, Long>
{
}
