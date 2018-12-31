package org.example.data;

import org.example.domain.Grant;
import org.example.domain.Organization;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OrganizationRepositoryTest
{
  @PersistenceContext
  private EntityManager          entityManager;
  @Autowired
  private OrganizationRepository repository;

  @Before
  public void setup()
  {
    final Organization organization = new Organization(getString());

    repository.save(organization);

    new Grant(organization, new Date(), BigDecimal.TEN);

    repository.saveAndFlush(organization);

    entityManager.clear();
  }

  @Test
  public void testFindAll()
  {
    final List<Organization> organizations = repository.findAll();

    assertNotNull(organizations);
    assertFalse(organizations.isEmpty());

    organizations.forEach(organization -> {
      assertNotNull(organization.getName());

      assertNotNull(organization.getGrant());
      assertNotNull(organization.getGrant().getAmount());
      assertNotNull(organization.getGrant().getDate());
      assertNotNull(organization.getGrant().getOrganization());

      assertEquals(organization, organization.getGrant().getOrganization());
    });
  }

  private String getString()
  {
    return UUID.randomUUID().toString();
  }
}
