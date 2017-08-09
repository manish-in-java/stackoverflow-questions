package org.example.stackoverflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ApplicationService
{
  private final DataSource bar;
  private final DataSource baz;
  private final DataSource foo;

  @Autowired
  public ApplicationService(@Qualifier("foo") final DataSource foo
      , @Qualifier("bar") final DataSource bar
      , @Qualifier("baz") final DataSource baz)
  {
    this.bar = bar;
    this.baz = baz;
    this.foo = foo;
  }

  public DataSource getBar()
  {
    return bar;
  }

  public DataSource getBaz()
  {
    return baz;
  }

  public DataSource getFoo()
  {
    return foo;
  }
}
