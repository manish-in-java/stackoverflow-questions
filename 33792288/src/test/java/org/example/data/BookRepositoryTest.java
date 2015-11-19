package org.example.data;

import org.example.domain.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class BookRepositoryTest
{
  @PersistenceContext
  private EntityManager  entityManager;
  @Autowired
  private BookRepository repository;

  @Before
  public void setup()
  {
    repository.saveAndFlush(new Book("Pride and Prejudice",
                                     "Pride and Prejudice is a novel of manners by Jane Austen, first published in 1813. The story follows the main character, Elizabeth Bennet, as she deals with issues of manners, upbringing, morality, education, and marriage in the society of the landed gentry of the British Regency."));
    repository.saveAndFlush(new Book("War and Peace",
                                     "War and Peace is a novel by the Russian author Leo Tolstoy, first published in its entirety in 1869. Epic in scale, it is regarded as one of the central works of world literature. It is considered Tolstoy's finest literary achievement, along with his other major prose work, Anna Karenina (1873–1877)."));

    entityManager.clear();
  }

  @After
  public void teardown()
  {
    repository.deleteAllInBatch();
  }

  @Test
  public void testFindAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase()
  {
    final String keyword = "AND";

    final List<Book> books = repository.findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);

    assertNotNull(books);
    assertFalse(books.isEmpty());

    for (final Book book : books)
    {
      assertNotNull(book);
      assertNotNull(book.getDescription());
      assertNotNull(book.getTitle());
    }
  }
}
