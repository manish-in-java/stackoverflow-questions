package org.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile
{
  @Id
  @Column(name = "profile_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @ManyToOne(optional = false)
  @JoinColumn(name = "gender_id", referencedColumnName = "gender_id")
  private Gender gender;
}
