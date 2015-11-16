package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
  private Set<Booking> bookings;

  @Column(name = "room_type")
  private Long roomType;

  Room()
  {
    super();
  }

  public Room(final Long roomType)
  {
    this();

    this.roomType = roomType;
  }

  public Set<Booking> getBookings()
  {
    return bookings;
  }

  public Long getID()
  {
    return id;
  }

  public Long getRoomType()
  {
    return roomType;
  }

  void addBooking(final Booking booking)
  {
    if (booking != null && this.equals(booking.getRoom()))
    {
      if (bookings == null)
      {
        bookings = new HashSet<>();
      }

      bookings.add(booking);
    }
  }
}
