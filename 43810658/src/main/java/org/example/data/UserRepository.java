package org.example.data;

import org.example.domain.User;

public interface UserRepository extends ModelRepository<User>
{
  User findByName(String name);
}
