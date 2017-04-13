package org.example.service;

import org.example.data.DepartmentRepository;
import org.example.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService
{
  @Autowired
  private DepartmentRepository repository;

  public List<Department> getDepartments()
  {
    final List<Department> departments = repository.findAll();

    departments.forEach(department -> department.getEmployees().size());

    return departments;
  }

  public void save(Department department)
  {
    repository.save(department);
  }
}
