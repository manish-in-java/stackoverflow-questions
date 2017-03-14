package org.example.service;

import org.example.data.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FooService
{
  @Autowired
  private FooRepository fooRepository;

  @Transactional
  public void delete(final Long id)
  {
    try
    {
      fooRepository.delete(id);
    }
    catch (final Throwable t)
    {
      //t.printStackTrace();
    }
  }
}
