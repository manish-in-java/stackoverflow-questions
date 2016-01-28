package org.example.data;

import org.example.domain.Child;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@ContextConfiguration("classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ChildRepositoryTest
{
  @Autowired
  private ChildRepository childRepository;

  @Before
  public void setup()
  {
    childRepository.save(new Child(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
    childRepository.save(new Child(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
    childRepository.save(new Child(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
    childRepository.save(new Child(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
  }

  @Test
  public void testFindAll()
  {
    Assert.assertFalse(childRepository.findAll().isEmpty());
  }
}
