package org.example.data;

import org.example.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long>
{
  @Query("select r from Room r join r.bookings b where not ((b.beginDate >= :initDate And b.beginDate <= :endDate) or (b.beginDate >= :initDate And b.endDate <= :endDate) or (b.beginDate <= :initDate and b.endDate >= :endDate) and b.approved = true and r.roomType = :roomType)")
  List<Room> findWithDates(@Param("initDate") Date initDate, @Param("endDate") Date endDate, @Param("roomType") Long roomType);
}
