package org.example.data;

import org.example.domain.Timetable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TimetableRepository extends CrudRepository<Timetable, Long>
{
  @Query("SELECT DISTINCT t.rosterDate FROM Timetable t")
  List<LocalDate> findAllRosterDates();
}
