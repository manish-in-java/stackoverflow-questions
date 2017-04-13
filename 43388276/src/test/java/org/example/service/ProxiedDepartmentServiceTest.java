package org.example.service;

import org.example.ProxiedClassConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ProxiedClassConfiguration.class)
public class ProxiedDepartmentServiceTest extends DepartmentServiceTest
{
}
