package org.example.service;

import org.example.Application;
import org.example.PrimarySolrContext;
import org.example.SecondarySolrContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = { Application.class, PrimarySolrContext.class, SecondarySolrContext.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchServiceTest
{
  @Autowired
  private SearchService service;

  @Test
  public void testServiceInitialized()
  {
    assertNotNull(service);

    assertEquals("primary", service.searchPrimary(null));
    assertEquals("secondary", service.searchSecondary(null));
  }
}
