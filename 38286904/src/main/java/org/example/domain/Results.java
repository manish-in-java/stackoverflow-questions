package org.example.domain;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlSeeAlso({ Artist.class, Venue.class })
public class Results
{
  @XmlElement
  private long         eventId;
  @XmlElement
  private String       ticketmasterEventId;
  @XmlElement
  private String       status;
  @XmlElement
  private String       name;
  @XmlElement
  private String       url;
  @XmlElement
  private String       eventDate;
  @XmlElement
  private String       onSaleDate;
  @XmlElement
  private String       preSaleDate;
  @XmlElement
  private int          categoyId;
  @XmlElement
  private String       parentCategory;
  @XmlElement
  private int          parentCategoryId;
  @XmlElement
  private Double       minPrice;
  @XmlElement
  private Double       maxPrice;
  @XmlElement(name = "Artists")
  private List<Artist> artists;
  @XmlElement
  private Venue        venue;

  public long getEventId()
  {
    return eventId;
  }

  public void setEventId(long eventId)
  {
    this.eventId = eventId;
  }

  public String getTicketmasterEventId()
  {
    return ticketmasterEventId;
  }

  public void setTicketmasterEventId(String ticketmasterEventId)
  {
    this.ticketmasterEventId = ticketmasterEventId;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public String getEventDate()
  {
    return eventDate;
  }

  public void setEventDate(String eventDate)
  {
    this.eventDate = eventDate;
  }

  public String getOnSaleDate()
  {
    return onSaleDate;
  }

  public void setOnSaleDate(String onSaleDate)
  {
    this.onSaleDate = onSaleDate;
  }

  public String getPreSaleDate()
  {
    return preSaleDate;
  }

  public void setPreSaleDate(String preSaleDate)
  {
    this.preSaleDate = preSaleDate;
  }

  public int getCategoyId()
  {
    return categoyId;
  }

  public void setCategoyId(int categoyId)
  {
    this.categoyId = categoyId;
  }

  public String getParentCategory()
  {
    return parentCategory;
  }

  public void setParentCategory(String parentCategory)
  {
    this.parentCategory = parentCategory;
  }

  public int getParentCategoryId()
  {
    return parentCategoryId;
  }

  public void setParentCategoryId(int parentCategoryId)
  {
    this.parentCategoryId = parentCategoryId;
  }

  public Double getMinPrice()
  {
    return minPrice;
  }

  public void setMinPrice(Double minPrice)
  {
    this.minPrice = minPrice;
  }

  public Double getMaxPrice()
  {
    return maxPrice;
  }

  public void setMaxPrice(Double maxPrice)
  {
    this.maxPrice = maxPrice;
  }

  public List<Artist> getArtists()
  {
    return artists;
  }

  public void setArtists(List<Artist> artists)
  {
    this.artists = artists;
  }

  public Venue getVenue()
  {
    return venue;
  }

  public void setVenue(Venue venue)
  {
    this.venue = venue;
  }
}
