package org.example.data;

import org.example.domain.AutoService;
import org.example.domain.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AssociationTest
{
  private static final String CATEGORY  = "Annual";
  private static final Random RANDOM    = new SecureRandom();
  private static final String SERVICING = "Servicing";
  private static final String WASHING   = "Washing";

  @Autowired
  private AutoServiceRepository autoServiceRepository;
  @Autowired
  private ServiceRepository     serviceRepository;

  @Before
  public void setup()
  {
    AutoService service = new AutoService(SERVICING);
    autoServiceRepository.save(service);

    for (int i = 0; i < getInt(); ++i)
    {
      serviceRepository.save(new Service(service, CATEGORY));
    }

    service = new AutoService(WASHING);
    autoServiceRepository.save(service);

    for (int i = 0; i < getInt(); ++i)
    {
      serviceRepository.save(new Service(service, CATEGORY));
    }
  }

  @Test
  public void testAssociation()
  {
    final List<Service> services = serviceRepository.findAllByCategoryAndAutoServiceServiceName(CATEGORY, SERVICING);

    assertNotNull(services);
    assertFalse(services.isEmpty());

    services.forEach(service ->
                     {
                       assertNotNull(service);
                       assertNotNull(service.getID());

                       assertNotNull(service.getCategory());
                       assertEquals(CATEGORY, service.getCategory());

                       assertNotNull(service.getAutoService());
                       assertNotNull(service.getAutoService().getID());
                       assertEquals(SERVICING, service.getAutoService().getServiceName());
                     });
  }

  private int getInt()
  {
    return 10 + RANDOM.nextInt(10);
  }
}
