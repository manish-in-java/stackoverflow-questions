package org.example.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends Model
{
  @Column(name = "name")
  private String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
  private Set<Token> tokens = new HashSet<>();

  User()
  {
    super();
  }

  public User(final String name)
  {
    this();

    this.name = name;
  }

  public void addToken(final Token token)
  {
    if (token != null)
    {
      tokens.add(token);
    }
  }

  public String getName()
  {
    return name;
  }

  public Set<Token> getTokens()
  {
    return tokens;
  }
}
