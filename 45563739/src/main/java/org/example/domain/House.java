package org.example.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "house")
public class House extends Model
{
  @OneToMany(mappedBy = "house")
  private Set<Car> cars;

  @OneToMany(mappedBy = "house")
  private Set<Person> persons;
}
