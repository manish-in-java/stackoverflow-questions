package org.example.controller;

import org.example.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController extends BaseController<Book>
{
  protected Book payload()
  {
    return new Book("Pride and Prejudice");
  }
}
