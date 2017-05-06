package org.example.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SiteRepositoryTest
{
  @Autowired
  private SiteRepository repository;

  @Test
  public void testFindSites()
  {
    assertNotNull(repository.findSites(getQuery()));
  }

  private String getQuery()
  {
    // Build Lat/Longs
    Set<String[]> coordinates = new HashSet<>();

    coordinates.add(new String[] { "42", "-72.95333862304689" });
    coordinates.add(new String[] { "42.05337156043361", "-71.06643676757814" });
    coordinates.add(new String[] { "41.32732632036624", "-71.06643676757814" });
    coordinates.add(new String[] { "41.32732632036624", "-72.95333862304689" });
    coordinates.add(new String[] { "42.05337156043361", "-72" });

    // Trim & Build Query

    String query = "(LATITUDE LIKE '";

    for (String[] c : coordinates)
    {

      c[0] += ".0";
      c[1] += ".0";

      String[] latArray = c[0].split("\\.");
      String[] lngArray = c[1].split("\\.");

      String lat = latArray[0] + "." + latArray[1].substring(0, 1) + "%";
      String lng = lngArray[0] + "." + lngArray[1].substring(0, 1) + "%";

      query += lat + "' AND LONGITUDE LIKE '" + lng + "') OR (LATITUDE LIKE '";
    }

    query = query.substring(0, query.length() - 20);

    System.out.println(query);

    return query;
  }
}
