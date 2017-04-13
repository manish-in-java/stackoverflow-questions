package org.example.service;

import org.example.domain.Department;

import java.util.List;

public interface DepartmentService
{
  List<Department> getDepartments();

  void save(Department department);
}
