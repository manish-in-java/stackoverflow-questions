package org.example.service;

import org.example.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService
{
  @Autowired
  private CommonBoardService commonBoardService;

  public Board startBoard()
  {
    return new Board();
  }

  public void synchronizeBoardState(final Board board)
  {
    if (board != null && inProgress(board))
    {
      if (!canPlayWithCurrentBoard(board))
      {
        commonBoardService.update(board, Board.AFK);
      }
      else
      {
        commonBoardService.update(board, Board.COMPLETED);
      }
    }
  }

  private boolean canPlayWithCurrentBoard(final Board board)
  {
    return !inProgress(board);
  }

  private boolean inProgress(final Board board)
  {
    return board != null && board.getStatus() == Board.IN_PROGRESS;
  }
}
