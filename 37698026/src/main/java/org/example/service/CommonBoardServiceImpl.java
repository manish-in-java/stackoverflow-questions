package org.example.service;

import org.example.data.BoardRepository;
import org.example.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommonBoardServiceImpl implements CommonBoardService
{
  @Autowired
  private BoardRepository boardRepository;

  public Board save(final Board board)
  {
    return boardRepository.saveAndFlush(board);
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public Board update(final Board board, final int status)
  {
    board.setStatus(status);

    return save(board);
  }
}
