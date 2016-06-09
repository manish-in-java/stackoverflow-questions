package org.example.service;

import org.example.domain.Board;

public interface CommonBoardService
{
  Board save(Board board);

  Board update(Board board, int status);
}
