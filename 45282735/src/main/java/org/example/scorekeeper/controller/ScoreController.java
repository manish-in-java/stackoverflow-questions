package org.example.scorekeeper.controller;

import org.example.scorekeeper.data.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController
{
  @Autowired
  private ScoreRepository repository;
}
