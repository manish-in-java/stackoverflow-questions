package org.example.data;

import org.example.domain.Trip;
import org.example.domain.TripLeg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface TripLegRepository extends ModelRepository<TripLeg>
{
  @Query("select distinct l.trip from TripLeg l where l.trip.traveler = ?1")
  Page<Trip> findAllTripsByTraveler(String traveler, Pageable page);
}
