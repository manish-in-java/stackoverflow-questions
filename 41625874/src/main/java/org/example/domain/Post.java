package org.example.domain;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post extends Model
{
  private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  @Column(name = "creation_date", nullable = false)
  private Date creationDate;

  @JoinColumn(name = "person_id", nullable = false)
  @ManyToOne
  private Person person;

  @Column(length = 1000, name = "title", nullable = false)
  private String title;

  Post()
  {
    super();
  }

  public Post(final Person person, final Date creationDate, final String title)
  {
    this();

    this.creationDate = creationDate;
    this.person = person;
    this.title = title;
  }

  public Date getCreationDate()
  {
    return creationDate;
  }

  public Person getPerson()
  {
    return person;
  }

  public String getTitle()
  {
    return title;
  }

  @Override
  public String toString()
  {
    return String.format("{ title : %s, person : %s, creationDate : %s }", title, person, FORMAT.format(creationDate));
  }
}
