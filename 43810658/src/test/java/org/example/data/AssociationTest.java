package org.example.data;

import org.example.domain.Token;
import org.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AssociationTest
{
  @Autowired
  private TokenRepository tokenRepository;
  @Autowired
  private UserRepository  userRepository;

  @Test
  public void testAssociation()
  {
    userRepository.save(new User("Bx"));
    final User user = userRepository.findByName("Bx");

    user.addToken(new Token(user, "Tx"));
    userRepository.save(user);

    final Token token = tokenRepository.findByValue("Tx");

    assertNotNull(token.getID());
    assertNotNull(token.getValue());
    assertNotNull(token.getUser());
    assertNotNull(token.getUser().getID());
    assertNotNull(token.getUser().getName());
  }
}
