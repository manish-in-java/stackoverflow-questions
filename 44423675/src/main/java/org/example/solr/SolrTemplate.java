package org.example.solr;

public class SolrTemplate
{
  private final SolrClient solrClient;

  public SolrTemplate(final SolrClient solrClient)
  {
    this.solrClient = solrClient;
  }

  public String getName()
  {
    return solrClient.getName();
  }
}
