package org.example.domain;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking
{
  @Column(name = "id")
  @Generated(GenerationTime.INSERT)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @Column(name = "approved")
  private boolean approved;

  @Column(name = "begin_date")
  private Date beginDate;

  @Column(name = "end_date")
  private Date endDate;

  @JoinColumn(name = "room_id")
  @ManyToOne
  private Room room;

  Booking()
  {
    super();
  }

  public Booking(final Room room, final Date beginDate, final Date endDate, final boolean approved)
  {
    this.approved = approved;
    this.beginDate = beginDate;
    this.endDate = endDate;
    this.room = room;

    room.addBooking(this);
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public Long getID()
  {
    return id;
  }

  public Room getRoom()
  {
    return room;
  }

  public Date getBeginDate()
  {
    return beginDate;
  }

  public boolean isApproved()
  {
    return approved;
  }

  public void setApproved(boolean approved)
  {
    this.approved = approved;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }

  public void setBeginDate(Date beginDate)
  {
    this.beginDate = beginDate;
  }
}
