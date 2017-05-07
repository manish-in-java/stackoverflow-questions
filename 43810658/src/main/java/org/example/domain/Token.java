package org.example.domain;

import javax.persistence.*;

@Entity
public class Token extends Model
{
  @JoinColumn(name = "user_id")
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private User user;

  @Column(name = "value")
  private String value;

  Token()
  {
    super();
  }

  public Token(final User user, final String value)
  {
    this();

    this.user = user;
    this.value = value;
  }

  public User getUser()
  {
    return user;
  }

  public String getValue()
  {
    return value;
  }
}
