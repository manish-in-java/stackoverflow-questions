package org.example.web;

import org.example.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController
{
  @RequestMapping(value = "/student", method = RequestMethod.POST)
  @ResponseBody
  public Student echo(@RequestBody final Student student)
  {
    return student;
  }
}
