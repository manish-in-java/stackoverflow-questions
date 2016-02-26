package org.example;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

public class Wrapper
{
  @Valid
  private final List<Bean> beans;

  public Wrapper(final Bean... beans)
  {
    this.beans = Arrays.asList(beans);
  }

  public List<Bean> getBeans()
  {
    return beans;
  }
}
