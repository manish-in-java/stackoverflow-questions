package org.example.service;

import org.example.NonProxiedClassConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = NonProxiedClassConfiguration.class)
public class NonProxiedDepartmentServiceTest extends DepartmentServiceTest
{
}
