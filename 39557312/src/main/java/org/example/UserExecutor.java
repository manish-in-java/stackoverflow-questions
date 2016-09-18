package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserExecutor extends AbstractExecutor
{
  @Autowired
  public UserExecutor(UserInput input, UserOutput output)
  {
    super(input, output);
  }
}
