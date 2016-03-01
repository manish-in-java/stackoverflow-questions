package org.example.service;

import net.sf.ehcache.Cache;
import org.example.domain.Organization;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrganizationServiceTest
{
  @Autowired
  private EhCacheCacheManager cacheManager;

  @Autowired
  private OrganizationService service;

  private Cache cache;

  @Before
  public void setup()
  {
    service.save(new Organization("Apple"));
    service.save(new Organization("Google"));
    service.save(new Organization("Microsoft"));

    cache = cacheManager.getCacheManager().getCache("main");
  }

  @Test
  public void testCacheEviction()
  {
    List<Organization> organizations = service.list();

    assertNotNull(organizations);
    assertFalse(organizations.isEmpty());
    assertNotEquals(0, organizations.size());

    for (Organization organization : organizations)
    {
      assertEquals(0, cache.getSize());

      service.find(organization.getID());

      assertNotEquals(0, cache.getSize());

      service.save(organization);

      assertEquals(0, cache.getSize());
    }
  }
}
