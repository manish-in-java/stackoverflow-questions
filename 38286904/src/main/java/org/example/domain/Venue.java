package org.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Venue
{
  @XmlElement
  private long   venueId;
  @XmlElement
  private long   ticketmasterVenueId;
  @XmlElement
  private String name;
  @XmlElement
  private String street;
  @XmlElement
  private String city;
  @XmlElement
  private String country;
  @XmlElement
  private String postcode;
  @XmlElement
  private String url;
  @XmlElement
  private String imageUrl;
  @XmlElement
  private String state;

  public long getVenueId()
  {
    return venueId;
  }

  public void setVenueId(long venueId)
  {
    this.venueId = venueId;
  }

  public long getTicketmasterVenueId()
  {
    return ticketmasterVenueId;
  }

  public void setTicketmasterVenueId(long ticketmasterVenueId)
  {
    this.ticketmasterVenueId = ticketmasterVenueId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getPostcode()
  {
    return postcode;
  }

  public void setPostcode(String postcode)
  {
    this.postcode = postcode;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public String getImageUrl()
  {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl)
  {
    this.imageUrl = imageUrl;
  }

  public String getState()
  {
    return state;
  }

  public void setState(String state)
  {
    this.state = state;
  }
}
