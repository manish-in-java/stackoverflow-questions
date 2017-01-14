package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person extends Model
{
  @JoinTable(inverseJoinColumns = @JoinColumn(name = "friend_id"), joinColumns = @JoinColumn(name = "person_id"), name = "person_friend")
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Person> friends;

  @Column(length = 100, name = "name", nullable = false)
  private String name;

  Person()
  {
    super();
  }

  public Person(final String name)
  {
    this();

    this.name = name;
  }

  public void addFriend(final Person friend)
  {
    if (friends == null)
    {
      friends = new HashSet<>();
    }

    if (!friends.contains(friend))
    {
      friends.add(friend);

      // Add this person as the friend's friend.
      friend.addFriend(this);
    }
  }

  public Set<Person> getFriends()
  {
    return friends;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public String toString()
  {
    return String.format("{ name : %s }", name);
  }
}
