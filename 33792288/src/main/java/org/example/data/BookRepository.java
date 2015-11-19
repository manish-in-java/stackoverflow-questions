package org.example.data;

import org.example.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>
{
  List<Book> findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
}
