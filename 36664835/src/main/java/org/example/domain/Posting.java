package org.example.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorColumn(name = "bargain", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("N")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "posting")
public class Posting
{
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(name = "plan")
  private String plan;

  @Column(name = "date", nullable = false)
  private LocalDateTime date;

  Posting()
  {
    super();
  }

  public Posting(final LocalDateTime date, final String plan)
  {
    this();

    this.date = date;
    this.plan = plan;
  }

  public LocalDateTime getDate()
  {
    return date;
  }

  public Long getID()
  {
    return id;
  }

  public String getPlan()
  {
    return plan;
  }
}
