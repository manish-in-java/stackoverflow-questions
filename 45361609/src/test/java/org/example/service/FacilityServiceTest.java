package org.example.service;

import org.example.data.FacilityRepository;
import org.example.domain.Facility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FacilityServiceTest
{
  @Mock
  private FacilityRepository repository;

  @InjectMocks
  private FacilityService service;

  @Before
  public void setup()
  {
    when(repository.findOne(any(Long.class))).thenAnswer(invocation -> {
      final Facility facility = mock(Facility.class);

      when(facility.getID()).thenReturn((Long) invocation.getArguments()[0]);
      when(facility.getName()).thenReturn(UUID.randomUUID().toString());
      when(facility.getState()).thenReturn("Active");

      return facility;
    });
  }

  @Test
  public void testGetOne()
  {
    final Facility facility = service.getOne(1L);

    assertNotNull(facility);
    assertNotNull(facility.getID());
    assertNotNull(facility.getName());
    assertNotNull(facility.getState());
    assertEquals(1L, (long) facility.getID());
  }
}
