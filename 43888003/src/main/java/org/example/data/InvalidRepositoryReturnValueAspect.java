package org.example.data;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.example.api.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InvalidRepositoryReturnValueAspect
{
  @AfterReturning(pointcut = "execution(* org.example.data.*Repository+.findOne(..))", returning = "result")
  public void intercept(final Object result)
  {
    if (result == null)
    {
      throw new ResourceNotFoundException();
    }
  }
}
