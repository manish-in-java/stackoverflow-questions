package org.example.web;

import org.example.domain.Person;
import org.example.web.converter.CsvHttpMessageConverter;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.http.MockHttpInputMessage;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Integration tests for {@link CsvHttpMessageConverter}.
 */
public class CsvHttpMessageConverterTests
{
  private final CsvHttpMessageConverter<List<Person>> converter = new CsvHttpMessageConverter<>();

  @Test
  public void testCanReadWithClassAndMediaType()
  {
    assertFalse(converter.canRead(Person.class, getMediaType()));
  }

  @Test
  public void testCanReadWithNonParameterizedTypeAndClassAndMediaType()
  {
    assertFalse(converter.canRead(Person.class, Person.class, getMediaType()));
  }

  @Test
  public void testCanReadWithParameterizedTypeAndClassAndMediaType()
  {
    assertTrue(converter.canRead(new SyntheticParameterizedType(List.class, Person.class), Person.class, getMediaType()));
  }

  @Test
  public void testCanWriteWithClassAndMediaType()
  {
    assertFalse(converter.canWrite(Person.class, getMediaType()));
  }

  @Test
  public void testCanWriteWithNonParameterizedTypeAndClassAndMediaType()
  {
    assertFalse(converter.canWrite(Person.class, Person.class, getMediaType()));
  }

  @Test
  public void testCanWriteWithParameterizedTypeAndClassAndMediaType()
  {
    assertTrue(converter.canWrite(getParameterizedType(), Person.class, getMediaType()));
  }

  @Test
  public void testGetSupportedMediaTypes()
  {
    assertTrue(converter.getSupportedMediaTypes().contains(getMediaType()));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testReadWithClass() throws IOException
  {
    converter.read(null, getHttpInputMessage());
  }

  @Test
  public void testReadWithTypeAndClass() throws IOException
  {
    final List<Person> persons = converter.read(getParameterizedType(), Person.class, getHttpInputMessage(getCSV()));

    assertNotNull(persons);
    assertFalse(persons.isEmpty());
    persons.forEach(person ->
                    {
                      assertNotNull(person);
                      assertNotNull(person.getFirstName());
                      assertNotNull(person.getLastName());
                    });
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testWriteWithClass() throws IOException
  {
    converter.write(null, getMediaType(), getHttpOutputMessage());
  }

  @Test
  public void testWriteWithTypeAndClass() throws IOException
  {
    final MockHttpOutputMessage message = getHttpOutputMessage();

    converter.write(Arrays.asList(new Person("Jane", "Smith"), new Person("John", "Smith")), getParameterizedType(), getMediaType(), message);

    final String output = message.getBodyAsString();

    assertNotNull(output);
  }

  private InputStream getCSV()
  {
    final StringBuilder buffer = new StringBuilder("First name,Last name").append(getLinebreak());

    buffer.append("Jane,Smith").append(getLinebreak());
    buffer.append("John,Smith").append(getLinebreak());

    return new ByteArrayInputStream(buffer.toString().getBytes());
  }

  private MockHttpInputMessage getHttpInputMessage()
  {
    return getHttpInputMessage(new MockHttpServletRequest().getInputStream());
  }

  private MockHttpInputMessage getHttpInputMessage(final InputStream stream)
  {
    return new MockHttpInputMessage(stream);
  }

  private MockHttpOutputMessage getHttpOutputMessage()
  {
    return new MockHttpOutputMessage();
  }

  private String getLinebreak()
  {
    return System.getProperty("line.separator");
  }

  private MediaType getMediaType()
  {
    return converter.getSupportedMediaTypes().get(0);
  }

  private ParameterizedType getParameterizedType()
  {
    return new SyntheticParameterizedType(List.class, Person.class);
  }

  private static class SyntheticParameterizedType implements ParameterizedType
  {
    private final Type[] actualTypeArguments;
    private final Type   rawType;

    private SyntheticParameterizedType(final Type rawType, final Type... actualTypeArguments)
    {
      this.actualTypeArguments = actualTypeArguments;
      this.rawType = rawType;
    }

    public Type[] getActualTypeArguments()
    {
      return actualTypeArguments;
    }

    public Type getOwnerType()
    {
      return null;
    }

    public Type getRawType()
    {
      return rawType;
    }
  }
}
