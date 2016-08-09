package org.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Data
{
  @XmlElement
  Details       details;
  @XmlElement
  List<Results> results;

  public Details getDetails()
  {
    return details;
  }

  public void setDetails(Details details)
  {
    this.details = details;
  }

  public List<Results> getResults()
  {
    return results;
  }

  public void setResults(List<Results> results)
  {
    this.results = results;
  }
}
