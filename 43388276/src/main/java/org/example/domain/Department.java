package org.example.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department extends Model
{
  @OneToMany(cascade = CascadeType.ALL)
  private Set<Employee> employees;

  @Column(name = "name")
  private String name;

  Department()
  {
    super();
  }

  public Department(final String name)
  {
    this.name = name;
  }

  public void addEmployee(final Employee employee)
  {
    if (employees == null)
    {
      employees = new HashSet<>();
    }

    employees.add(employee);
  }

  public Set<Employee> getEmployees()
  {
    return employees;
  }

  public String getName()
  {
    return name;
  }
}
