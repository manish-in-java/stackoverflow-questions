package org.example.data;

import org.example.domain.Application;
import org.example.domain.ApplicationUser;
import org.example.domain.Tenant;
import org.example.domain.TenantUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ApplicationRepositoryTest
{
  @Autowired
  private ApplicationRepository repository;

  @Before
  public void setup()
  {
    final Tenant tenant = new Tenant();
    tenant.addUser(new TenantUser());

    final Application application = new Application();
    application.addTenant(tenant);
    application.addUser(new ApplicationUser());

    repository.saveAndFlush(application);
  }

  @Test
  public void testFindAll()
  {
    final List<Application> applications = repository.findAll();

    assertNotNull(applications);
    assertFalse(applications.isEmpty());
    applications.forEach(application -> {
      assertNotNull(application);
      assertFalse(application.getTenants().isEmpty());
      assertFalse(application.getUsers().isEmpty());
    });
  }
}
