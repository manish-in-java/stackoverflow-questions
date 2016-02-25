package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement(name = "student")
@XmlType(propOrder = { "id", "name", "graduationTime", "courses" })
@JsonPropertyOrder({ "id", "name", "graduationTime", "courses" })
public class Student implements Serializable
{
  private static final long serialVersionUID = 1L;

  private int    id;
  private String name;
  private String graduationTime;
  private ArrayList<Course> courses = new ArrayList<Course>();

  public Student()
  {
  }

  public Student(int id, String name, String graduationTime)
  {
    this.id = id;
    this.name = name;
    this.graduationTime = graduationTime;
  }

  @XmlElement
  public int getId()
  {
    return id;
  }

  @XmlElement
  public String getName()
  {
    return name;
  }

  @XmlElement
  public String getGraduationTime()
  {
    return graduationTime;
  }

  @XmlElement
  public ArrayList<Course> getCourses()
  {
    return courses;
  }

  public void setId(int value)
  {
    this.id = value;
  }

  public void setName(String value)
  {
    this.name = value;
  }

  public void setGraduationTime(String value)
  {
    this.graduationTime = value;
  }

  public void setCourses(ArrayList<Course> value)
  {
    this.courses = value;
  }

  @JsonIgnore
  public String toString()
  {
    return this.name + " - "
        + graduationTime == null ? "Unknown" : graduationTime.toString();
  }
}
