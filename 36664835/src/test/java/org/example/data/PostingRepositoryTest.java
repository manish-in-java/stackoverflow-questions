package org.example.data;

import org.example.domain.Bargain;
import org.example.domain.Posting;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
abstract class PostingRepositoryTest
{
  @Autowired
  private PostingRepository repository;

  @Before
  public void setup()
  {
    repository.save(new Bargain(getEarliest(), null, BigDecimal.TEN));
    repository.save(new Bargain(getEarliest(), "PLAN", BigDecimal.TEN));

    repository.save(new Bargain(getLatest(), null, BigDecimal.TEN));
    repository.save(new Bargain(getLatest(), "PLAN", BigDecimal.TEN));
  }

  @Test
  public void testFindOrphaned()
  {
    final List<Posting> orphaned = repository.findOrphaned(getEarliest(), getLatest());

    assertNotNull(orphaned);
    assertFalse(orphaned.isEmpty());

    for (final Posting posting : orphaned)
    {
      assertNotNull(posting);
      assertNotNull(posting.getDate());
      assertNotNull(posting.getID());

      assertNull(posting.getPlan());
    }
  }

  private LocalDateTime getEarliest()
  {
    return LocalDateTime.of(2000, 1, 1, 0, 0);
  }

  private LocalDateTime getLatest()
  {
    return LocalDateTime.of(2099, 12, 31, 23, 59);
  }
}
