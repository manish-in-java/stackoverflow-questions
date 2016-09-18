package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest
{
  @Autowired
  private UserInput    input;
  @Autowired
  private IUserService service;

  @Test
  public void testExecute()
  {
    assertNotNull(service.execute(input));
  }
}
