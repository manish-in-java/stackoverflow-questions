package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Greeting
{
  private String message;
  private Date   time;
}
