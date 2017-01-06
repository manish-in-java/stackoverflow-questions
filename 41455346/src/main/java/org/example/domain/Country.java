package org.example.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Country implements Serializable
{
  private static final long serialVersionUID = -1238480047355425991L;

  //@Expose
  //@SerializedName("alpha2_code")
  private String alpha2Code;
  //@Expose
  //@SerializedName("alpha3_code")
  private String alpha3Code;
  //@Expose
  //@SerializedName("name")
  private String name;

  public String getAlpha2Code()
  {
    return alpha2Code;
  }

  public String getAlpha3Code()
  {
    return alpha3Code;
  }

  public String getName()
  {
    return name;
  }

  public void setAlpha2Code(String alpha2Code)
  {
    this.alpha2Code = alpha2Code;
  }

  public void setAlpha3Code(String alpha3Code)
  {
    this.alpha3Code = alpha3Code;
  }

  public void setName(String name)
  {
    this.name = name;
  }
}
