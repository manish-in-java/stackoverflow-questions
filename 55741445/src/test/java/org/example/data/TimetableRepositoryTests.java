package org.example.data;

import org.example.domain.Timetable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimetableRepositoryTests
{
  @Autowired
  private TimetableRepository repository;

  @Before
  public void setup()
  {
    repository.save(new Timetable(UUID.randomUUID().toString(), LocalDate.now().minusDays(2)));
    repository.save(new Timetable(UUID.randomUUID().toString(), LocalDate.now().minusDays(1)));
    repository.save(new Timetable(UUID.randomUUID().toString(), LocalDate.now()));
    repository.save(new Timetable(UUID.randomUUID().toString(), LocalDate.now().plusDays(1)));
    repository.save(new Timetable(UUID.randomUUID().toString(), LocalDate.now().plusDays(2)));
  }

  @Test
  public void testFindAllRosterDates()
  {
    final List<LocalDate> rosterDates = repository.findAllRosterDates();

    assertNotNull(rosterDates);
    assertFalse(rosterDates.isEmpty());
    assertEquals(5, rosterDates.size());

    rosterDates.forEach(Assert::assertNotNull);
  }
}
