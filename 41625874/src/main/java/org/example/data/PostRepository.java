package org.example.data;

import org.example.domain.Person;
import org.example.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface PostRepository extends ModelRepository<Post>
{
  @Query("SELECT "
      + "  DISTINCT p "
      + "FROM "
      + "  Post p "
      + "INNER JOIN "
      + "  p.person.friends f "
      + "WHERE "
      + "  (p.person = ?1 OR f = ?1) "
      + "AND p.creationDate < ?2")
  Page<Post> findAllByPersonOrFriendsAndCreationDate(Person person, Date creationDate, Pageable page);
}
