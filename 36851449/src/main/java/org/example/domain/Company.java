package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "company")
@XmlRootElement(name = "company")
public class Company
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @SuppressWarnings("unused")
  @XmlAttribute(name = "id")
  private Long id;

  @Column(length = 1000, name = "name", nullable = false)
  @XmlAttribute(name = "id")
  private String name;

  public Long getID()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(final String name)
  {
    this.name = name;
  }
}
