package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository
{
  @Autowired
  String findAllQuery;
}
