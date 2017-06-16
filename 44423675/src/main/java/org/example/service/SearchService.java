package org.example.service;

import org.example.solr.SolrTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SearchService
{
  @Autowired
  @Qualifier("primary")
  private SolrTemplate primarySearchTemplate;

  @Autowired
  @Qualifier("secondary")
  private SolrTemplate secondarySearchTemplate;

  public String searchPrimary(final String keywords)
  {
    return primarySearchTemplate.getName();
  }

  public String searchSecondary(final String keywords)
  {
    return secondarySearchTemplate.getName();
  }
}
