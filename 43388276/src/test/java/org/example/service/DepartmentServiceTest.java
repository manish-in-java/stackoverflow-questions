package org.example.service;

import org.example.domain.Department;
import org.example.domain.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
abstract class DepartmentServiceTest
{
  @Autowired
  private DepartmentService service;

  @PersistenceContext
  private EntityManager entityManager;

  @Before
  public void setup()
  {
    final Department department = new Department("Finance");
    department.addEmployee(new Employee("Alice"));
    department.addEmployee(new Employee("Bob"));
    department.addEmployee(new Employee("Chris"));
    department.addEmployee(new Employee("Dave"));

    service.save(department);

    entityManager.clear();
  }

  @Test
  public void testGetDepartments()
  {
    final List<Department> departments = service.getDepartments();

    assertNotNull(departments);
    assertFalse(departments.isEmpty());

    departments.forEach(department ->
                        {
                          assertNotNull(department);
                          assertNotNull(department.getName());
                          assertNotNull(department.getEmployees());
                          assertNotNull(department.getEmployees().isEmpty());

                          department.getEmployees().forEach(employee ->
                                                            {
                                                              assertNotNull(employee);
                                                              assertNotNull(employee.getName());
                                                            });
                        });
  }
}
