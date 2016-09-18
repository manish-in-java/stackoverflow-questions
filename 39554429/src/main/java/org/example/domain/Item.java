package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item extends Model
{
  @JoinColumn(name = "user_id", nullable = false)
  @ManyToOne
  private User user;

  @Column(insertable = false, name = "user_id", updatable = false)
  private Long userID;

  public User getUser()
  {
    return user;
  }

  public Long getUserID()
  {
    return userID;
  }

  void setUser(final User user)
  {
    this.user = user;
  }
}
