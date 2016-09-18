package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService
{
  private final IExecutor executor;

  @Autowired
  public UserService(final IExecutor executor)
  {
    this.executor = executor;
  }

  public UserOutput execute(UserInput input)
  {
    return (UserOutput) executor.execute();
  }
}
