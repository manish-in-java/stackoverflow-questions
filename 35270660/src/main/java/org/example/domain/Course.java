package org.example.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlRootElement(name = "course")
@XmlType(propOrder = { "courseName", "score" })
@JsonPropertyOrder({ "courseName", "score" })
public class Course implements Serializable
{
  private static final long serialVersionUID = 1L;

  private String  courseName;
  private Integer score;

  public Course()
  {
  }

  public Course(String courseName, Integer score)
  {
    this.courseName = courseName;
    this.score = score;
  }

  @XmlElement
  public String getCourseName()
  {
    return courseName;
  }

  @XmlElement
  public Integer getScore()
  {
    return score;
  }

  public void setCourseName(String value)
  {
    courseName = value;
  }

  public void setScore(Integer value)
  {
    score = value;
  }
}
