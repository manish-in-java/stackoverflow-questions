package org.example.data;

import org.example.domain.Board;
import org.example.service.BoardService;
import org.example.service.CommonBoardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class BoardServiceTest
{
  private Board board;

  @Autowired
  private BoardRepository boardRepository;

  @Autowired
  private BoardService       boardService;
  @Autowired
  private CommonBoardService commonBoardService;

  @Before
  public void setup()
  {
    board = boardService.startBoard();

    board = commonBoardService.save(board);
  }

  @Test
  public void testSynchronizeBoardStatus()
  {
    assertNotNull(board.getID());
    assertEquals(1, boardRepository.count());

    boardService.synchronizeBoardState(board);

    assertEquals(1, boardRepository.count());
    assertNotNull(board.getID());
  }
}
