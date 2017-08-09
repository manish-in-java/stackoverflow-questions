package org.example.stackoverflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServiceTest
{
  @Autowired
  private ApplicationService service;

  @Test
  public void testDependenciesInjected()
  {
    assertNotNull(service.getBar());
    assertNotNull(service.getBaz());
    assertNotNull(service.getFoo());
  }
}
