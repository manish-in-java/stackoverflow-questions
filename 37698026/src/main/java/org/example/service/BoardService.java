package org.example.service;

import org.example.domain.Board;

public interface BoardService
{
  Board startBoard();

  void synchronizeBoardState(Board board);
}
