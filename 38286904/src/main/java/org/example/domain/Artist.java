package org.example.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Artist
{
  @XmlElement
  private long   artistId;
  @XmlElement
  private long   ticketMasterArtistId;
  @XmlElement
  private String name;
  @XmlElement
  private String url;
  @XmlElement
  private String imageUrl;
  @XmlElement
  private String category;
  @XmlElement
  private int    categoryId;
  @XmlElement
  private String parentCategory;
  @XmlElement
  private int    parentCategoryId;

  public long getArtistId()
  {
    return artistId;
  }

  public void setArtistId(long artistId)
  {
    this.artistId = artistId;
  }

  public long getTicketMasterArtistId()
  {
    return ticketMasterArtistId;
  }

  public void setTicketMasterArtistId(long ticketMasterArtistId)
  {
    this.ticketMasterArtistId = ticketMasterArtistId;
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

  public String getImageUrl()
  {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl)
  {
    this.imageUrl = imageUrl;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String category)
  {
    this.category = category;
  }

  public int getCategoryId()
  {
    return categoryId;
  }

  public void setCategoryId(int categoryId)
  {
    this.categoryId = categoryId;
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
}
