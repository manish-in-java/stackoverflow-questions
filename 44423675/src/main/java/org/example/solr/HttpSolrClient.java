package org.example.solr;

public class HttpSolrClient implements SolrClient
{
  private final String name;
  private final String url;

  public HttpSolrClient(final String name, final String url)
  {
    this.name = name;
    this.url = url;
  }

  public String getName()
  {
    return name;
  }

  public String getUrl()
  {
    return url;
  }
}
