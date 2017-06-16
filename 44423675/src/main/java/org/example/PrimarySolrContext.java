package org.example;

import org.example.solr.HttpSolrClient;
import org.example.solr.SolrClient;
import org.example.solr.SolrTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrimarySolrContext
{
  @Bean
  public SolrClient primarySolrClient()
  {
    return new HttpSolrClient("primary", "https://www.primary.com/solr");
  }

  @Bean(name = "primary")
  public SolrTemplate solrTemplate()
  {
    return new SolrTemplate(primarySolrClient());
  }
}
