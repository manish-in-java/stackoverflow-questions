package org.example.web.converter;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * <p>
 * An {@link HttpMessageConverter} that reads Java objects from and writes
 * Java objects as {@code comma-separated values (CSV)} using the
 * <a href="https://github.com/uniVocity/univocity-parsers">uniVocity</a>
 * CSV parsing library.
 * </p>
 * <p>
 * Since CSV content is a collection of rows, this converter can only read and
 * write {@link Collection}s of objects and not individual objects at a time.
 * </p>
 *
 * @param <T> The {@link Collection} type to read or write.
 */
public class CsvHttpMessageConverter<T extends Collection>
    implements GenericHttpMessageConverter<T>, HttpMessageConverter<T>
{
  public static final MediaType DEFAULT_MEDIA_TYPE = new MediaType("text", "csv");

  private final MediaType[] mediaTypes;

  /**
   * Sets the default media type supported by this converter as
   * {@code text/csv;charset=urf-8}.
   */
  public CsvHttpMessageConverter()
  {
    this(DEFAULT_MEDIA_TYPE);
  }

  /**
   * Sets the media types supported by this converter.
   *
   * @param mediaTypes An array of {@link MediaType}s.
   */
  public CsvHttpMessageConverter(final MediaType... mediaTypes)
  {
    this.mediaTypes = mediaTypes != null && mediaTypes.length > 0
                      ? mediaTypes
                      : new MediaType[] { DEFAULT_MEDIA_TYPE };
  }

  /**
   * Gets whether this converter can read an individual object. Always returns
   * {@code false} because CSV content is a collection of objects and therefore
   * this converter cannot read objects individually.
   *
   * @param contextClass The type of object to read.
   * @param mediaType    The media type for the object content.
   * @return {@code false}.
   */
  @Override
  public boolean canRead(final Class<?> contextClass, final MediaType mediaType)
  {
    return false;
  }

  /**
   * Gets whether this converter can read an object of a generic type. Returns
   * {@code true} if the specified generic type refers to a {@link Collection}
   * type.
   *
   * @param type         The type of generic object to read.
   * @param contextClass The type of objects within the generic type to read.
   * @param mediaType    The media type for the object content.
   * @return {@code true} if {@code type} is a {@link Collection},
   * {@code false} otherwise.
   */
  @Override
  public boolean canRead(final Type type, final Class<?> contextClass, final MediaType mediaType)
  {
    if (!(type instanceof ParameterizedType))
    {
      return false;
    }
    else
    {
      final ParameterizedType parameterizedType = (ParameterizedType) type;
      if (!(parameterizedType.getRawType() instanceof Class))
      {
        return false;
      }
      else
      {
        final Class<?> rawType = (Class) parameterizedType.getRawType();
        if (!Collection.class.isAssignableFrom(rawType))
        {
          return false;
        }
        else if (parameterizedType.getActualTypeArguments().length != 1)
        {
          return false;
        }

        return parameterizedType.getActualTypeArguments()[0] instanceof Class && canRead(mediaType);
      }
    }
  }

  /**
   * Gets whether this converter can write an individual object. Always returns
   * {@code false} because CSV content is a collection of objects and therefore
   * this converter cannot write objects individually.
   *
   * @param contextClass The type of object to write.
   * @param mediaType    The media type for the object content.
   * @return {@code false}.
   */
  @Override
  public boolean canWrite(final Class<?> contextClass, final MediaType mediaType)
  {
    return canRead(contextClass, mediaType);
  }

  /**
   * Gets whether this converter can write an object of a generic type. Returns
   * {@code true} if the specified generic type refers to a {@link Collection}
   * type.
   *
   * @param type         The type of generic object to write.
   * @param contextClass The type of objects within the generic type to write.
   * @param mediaType    The media type for the object content.
   * @return {@code true} if {@code type} is a {@link Collection},
   * {@code false} otherwise.
   */
  @Override
  public boolean canWrite(final Type type, final Class<?> contextClass, final MediaType mediaType)
  {
    return canRead(type, contextClass, mediaType);
  }

  /**
   * Gets the media types supported by this converter. By default only
   * {@code text/csv;charset=utf-8} is supported.
   *
   * @return The media types supported by this converter.
   */
  @Override
  public List<MediaType> getSupportedMediaTypes()
  {
    return Arrays.asList(mediaTypes);
  }

  /**
   * Throws {@link UnsupportedOperationException} because CSV content cannot be
   * read without knowing the type of the rows to be read.
   */
  @Override
  public T read(final Class<? extends T> clazz, final HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException
  {
    throw new UnsupportedOperationException("Reading CSV content without knowing the type of rows is not possible.");
  }

  /**
   * Reads CSV content into a collection of a specified type.
   *
   * @param type         The type of generic object to write.
   * @param contextClass The type of objects within the generic type to write.
   * @param inputMessage The CSV content to read.
   * @return A collection of objects with each object representing a row in
   * the CSV.
   * @throws IOException                     if CSV content cannot be read.
   * @throws HttpMessageNotReadableException if the content is not valid as
   *                                         CSV.
   */
  @Override
  public T read(final Type type, final Class<?> contextClass, final HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException
  {
    final ParameterizedType parameterizedType = (ParameterizedType) type;
    final T result = this.createCollection((Class) parameterizedType.getRawType());
    final Class elementClass = (Class) parameterizedType.getActualTypeArguments()[0];

    try
    {
      final BeanListProcessor<?> processor = new BeanListProcessor<>(elementClass);
      final CsvParserSettings parserSettings = new CsvParserSettings();
      parserSettings.setHeaderExtractionEnabled(true);
      parserSettings.setLineSeparatorDetectionEnabled(true);
      parserSettings.setProcessor(processor);

      new CsvParser(parserSettings).parse(inputMessage.getBody());

      result.addAll(processor.getBeans());

      return result;
    }
    catch (final Exception e)
    {
      throw new HttpMessageNotReadableException("Could not read CSV data for [" + elementClass + "]: " + e.getMessage(), e);
    }
  }

  /**
   * Throws {@link UnsupportedOperationException} because CSV content cannot be
   * read into a single object.
   */
  @Override
  public void write(final T t, final MediaType contentType, final HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException
  {
    throw new UnsupportedOperationException();
  }

  /**
   * Writes CSV content.
   *
   * @param content       The CSV content to write.
   * @param type          The type of generic object to write.
   * @param outputMessage The destination where the CSV content should be
   *                      written.
   * @throws IOException                     if CSV content cannot be written.
   * @throws HttpMessageNotWritableException if the content is not valid as
   *                                         CSV.
   */
  @Override
  public void write(final T content, final Type type, final MediaType contentType, final HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException
  {
    final ParameterizedType parameterizedType = (ParameterizedType) type;
    final Class elementClass = (Class) parameterizedType.getActualTypeArguments()[0];

    try
    {
      final CsvWriterSettings writerSettings = new CsvWriterSettings();
      writerSettings.setRowWriterProcessor(new BeanWriterProcessor<>(elementClass));

      final CsvWriter writer = new CsvWriter(outputMessage.getBody(), writerSettings);
      writer.writeHeaders();

      for (final Object row : content)
      {
        writer.processRecord(row);
      }

      writer.close();
    }
    catch (final Exception e)
    {
      throw new HttpMessageNotWritableException("Could not write CSV data for [" + elementClass + "]: " + e.getMessage(), e);
    }
  }

  /**
   * Returns {@code true} if any of the supported media types
   * {@link MediaType#includes(MediaType) include} the given media type.
   *
   * @param mediaType the media type to read, can be {@code null} if not
   *                  specified. Typically the value of a {@code Content-Type}
   *                  header.
   * @return {@code true} if the supported media types include the media type,
   * or if the media type is {@code null}
   */
  private boolean canRead(MediaType mediaType)
  {

    return mediaType == null
        || getSupportedMediaTypes().stream().anyMatch(s -> s.includes(mediaType));
  }

  /**
   * Creates an instance of a {@link Collection} type.
   *
   * @param collectionClass The {@link Collection} type to create.
   * @return An instance of the specified {@link Collection} type, if valid,
   * {@code null} otherwise.
   * @throws IllegalArgumentException if the specified type cannot be
   *                                  instantiated through a default
   *                                  constructor.
   */
  private T createCollection(final Class<?> collectionClass)
  {
    if (!collectionClass.isInterface())
    {
      try
      {
        return (T) collectionClass.newInstance();
      }
      catch (final Throwable var3)
      {
        throw new IllegalArgumentException("Could not instantiate collection class: " + collectionClass.getName(), var3);
      }
    }
    else
    {
      return (T) (List.class == collectionClass ? new ArrayList() : (SortedSet.class == collectionClass ? new TreeSet() : new LinkedHashSet()));
    }
  }
}
