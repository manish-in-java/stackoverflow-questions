package org.example.data;

import org.example.domain.Child;
import org.example.domain.Parent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AssociationTest
{
  @Autowired
  private ParentRepository parentRepository;

  @Test
  public void testAssociation()
  {
    final Child child = new Child();

    final Parent parent = new Parent();
    parent.addChild(child);

    parentRepository.saveAndFlush(parent);

    assertNotNull(child.getID());
    assertNotNull(child.getParent());

    assertNotNull(parent.getChildren());
    assertNotNull(parent.getID());

    assertFalse(parent.getChildren().isEmpty());
    assertNotNull(parent.getChildren().iterator().next());
    assertEquals(child, parent.getChildren().iterator().next());
    assertEquals(parent, child.getParent());

    final Parent stepParent = new Parent();
    stepParent.addChild(child);

    parentRepository.saveAndFlush(stepParent);

    assertNotNull(child.getID());
    assertNotNull(child.getParent());

    assertNotNull(parent.getChildren());
    assertNotNull(parent.getID());

    assertNotNull(stepParent.getChildren());
    assertNotNull(stepParent.getID());

    assertTrue(parent.getChildren().isEmpty());

    assertFalse(stepParent.getChildren().isEmpty());
    assertNotNull(stepParent.getChildren().iterator().next());
    assertEquals(child, stepParent.getChildren().iterator().next());
    assertEquals(stepParent, child.getParent());
  }
}
