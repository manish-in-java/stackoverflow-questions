package org.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Details
{
  @XmlElement
  private int totalResults;
  @XmlElement
  private int totalPages;
  @XmlElement
  private int currentPage;

  public int getTotalResults()
  {
    return totalResults;
  }

  public void setTotalResults(int totalResults)
  {
    this.totalResults = totalResults;
  }

  public int getTotalPages()
  {
    return totalPages;
  }

  public void setTotalPages(int totalPages)
  {
    this.totalPages = totalPages;
  }

  public int getCurrentPage()
  {
    return currentPage;
  }

  public void setCurrentPage(int currentPage)
  {
    this.currentPage = currentPage;
  }

  public int getResultsPerPage()
  {
    return resultsPerPage;
  }

  public void setResultsPerPage(int resultsPerPage)
  {
    this.resultsPerPage = resultsPerPage;
  }

  @XmlElement

  private int resultsPerPage;
}
