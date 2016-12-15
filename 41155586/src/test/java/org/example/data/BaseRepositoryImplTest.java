package org.example.data;

import org.example.domain.BaseImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseRepositoryImplTest
{
  @Autowired
  private BaseRepositoryImpl baseRepository;

  @Test
  public void testSave()
  {
    BaseImpl base = new BaseImpl();
    base.setFirstName("Spring");

    System.out.println(baseRepository.save(base).getId());
  }
}
