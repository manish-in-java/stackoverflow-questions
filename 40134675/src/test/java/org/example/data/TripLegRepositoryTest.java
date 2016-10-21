package org.example.data;

import org.example.domain.Location;
import org.example.domain.Trip;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TripLegRepositoryTest
{
  private static final String TRAVELER = "John Smith";

  @Autowired
  private LocationRepository locationRepository;
  @Autowired
  private TripRepository     tripRepository;
  @Autowired
  private TripLegRepository  tripLegRepository;

  @Before
  public void setup()
  {
    final Location chicago = locationRepository.save(new Location("ORD", "Chicago"));
    final Location denver = locationRepository.save(new Location("DEN", "Denver"));
    final Location honolulu = locationRepository.save(new Location("HNL", "Honolulu"));
    final Location losAngeles = locationRepository.save(new Location("LAX", "Los Angeles"));
    final Location newYork = locationRepository.save(new Location("JFK", "New York"));
    final Location sanFransisco = locationRepository.save(new Location("SFO", "San Fransisco"));

    final Trip outbound = new Trip(TRAVELER);
    outbound.addLeg(newYork, chicago, getDate(0, 1));
    outbound.addLeg(chicago, denver, getDate(1, 1));
    outbound.addLeg(denver, sanFransisco, getDate(2, 1));
    outbound.addLeg(sanFransisco, losAngeles, getDate(3, 1));
    outbound.addLeg(losAngeles, honolulu, getDate(4, 1));

    final Trip inbound = new Trip(TRAVELER);
    inbound.addLeg(honolulu, losAngeles, getDate(5, 1));
    inbound.addLeg(losAngeles, sanFransisco, getDate(6, 1));
    inbound.addLeg(sanFransisco, denver, getDate(7, 1));
    inbound.addLeg(denver, chicago, getDate(8, 1));
    inbound.addLeg(chicago, newYork, getDate(9, 1));

    tripRepository.save(outbound);
    tripRepository.save(inbound);
  }

  @Test
  public void testFindAllTripsByTraveler()
  {
    final Page<Trip> trips = tripLegRepository.findAllTripsByTraveler(TRAVELER, new PageRequest(0, 100, new Sort("departure")));

    assertNotNull(trips);
    assertNotEquals(0, trips.getTotalElements());
    assertNotEquals(0, trips.getTotalPages());

    trips.forEach(trip ->
                  {
                    System.out.println("TRIP");
                    assertNotNull(trip);
                    assertEquals(TRAVELER, trip.getTraveler());
                    assertFalse(trip.getLegs().isEmpty());
                  });
  }

  private Date getDate(final int month, final int date)
  {
    final Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DATE, date);
    calendar.set(Calendar.MONTH, month % 12);

    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);

    return calendar.getTime();
  }
}
