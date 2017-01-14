package org.example.data;

import org.example.domain.Person;
import org.example.domain.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PostRepositoryTest
{
  private static final String PERSON_NAME = "John";
  private static final Random RANDOM      = new SecureRandom();

  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private PostRepository   postRepository;

  @Before
  public void setup()
  {
    // Add a person with a known name.
    final Person person = personRepository.saveAndFlush(new Person(PERSON_NAME));

    // Add some friends for the person.
    IntStream.range(1, RANDOM.nextInt(20) + 1)
             .forEach(i ->
                      {
                        final Person friend = personRepository.saveAndFlush(new Person(UUID.randomUUID().toString()));

                        person.addFriend(friend);

                        personRepository.saveAndFlush(person);
                      });

    final Calendar now = Calendar.getInstance();
    final int year = now.get(Calendar.YEAR);

    // Add some random number of posts for the person.
    IntStream.range(1, RANDOM.nextInt(10) + 1)
             .forEach(i ->
                      {
                        postRepository.saveAndFlush(new Post(person, getDate(year), UUID.randomUUID().toString()));
                      });

    // Also add some random number of posts for each of the person's friends.
    person.getFriends()
          .forEach(friend ->
                   {
                     IntStream.range(1, RANDOM.nextInt(10) + 1)
                              .forEach(i ->
                                       {
                                         postRepository.saveAndFlush(new Post(friend, getDate(year), UUID.randomUUID().toString()));
                                       });
                   });
  }

  @Test
  public void testFindAllByPersonOrFriendsAndCreationDate()
  {
    // Load the person of interest.
    final Person person = personRepository.findByName(PERSON_NAME);

    // Find a page of posts created by a person or their friends.
    final Page<Post> posts = postRepository.findAllByPersonOrFriendsAndCreationDate(person
        , new Date()
        , new PageRequest(0, 100, new Sort("creationDate", "title")));

    // Ensure that posts were loaded successfully.
    assertNotNull(posts);
    assertNotEquals(0, posts.getSize());

    Date creationDate = null;
    for (final Post post : posts)
    {
      // Ensure that the post fields have been initialized properly.
      assertNotNull(post);
      assertNotNull(post.getCreationDate());
      assertNotNull(post.getID());
      assertNotNull(post.getPerson());
      assertNotNull(post.getTitle());

      // Ensure that the post was created by the person of interest of one of their friends.
      assertTrue(person.equals(post.getPerson()) || person.getFriends().contains(post.getPerson()));

      // Ensure that the posts have been loaded in increasing order of creation date.
      assertTrue(creationDate == null || creationDate.compareTo(post.getCreationDate()) <= 0);

      System.out.println(post);

      creationDate = post.getCreationDate();
    }
  }

  private Date getDate(final int year)
  {
    final Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DATE, RANDOM.nextInt(28) + 1);
    calendar.set(Calendar.MONTH, RANDOM.nextInt(12));
    calendar.set(Calendar.YEAR, 1900 + RANDOM.nextInt(year - 1900));

    return calendar.getTime();
  }
}
