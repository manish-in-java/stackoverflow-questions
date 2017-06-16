package org.example;

import org.example.solr.HttpSolrClient;
import org.example.solr.SolrClient;
import org.example.solr.SolrTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondarySolrContext
{
  @Bean
  public SolrClient secondarySolrClient()
  {
    return new HttpSolrClient("secondary", "https://www.secondary.com/solr");
  }

  @Bean(name = "secondary")
  public SolrTemplate solrTemplate()
  {
    return new SolrTemplate(secondarySolrClient());
  }
}
