package org.example;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ModelTest
{
  @Test
  public void testAnnotationPresent()
  {
    final Class<Model> clazz = Model.class;

    final Field[] fields = clazz.getDeclaredFields();

    assertNotNull(fields);
    assertNotEquals(0, fields.length);

    Stream.of(fields).forEach(field ->
                              {
                                assertNull(field.getAnnotation(Identity.class));
                                assertNotNull(field.getAnnotation(InheritedIdentity.class));
                              });
  }
}
