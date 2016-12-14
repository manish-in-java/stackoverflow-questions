package org.example;

public class SessionFactory
{
  private DataSource dataSource;

  public DataSource getDataSource()
  {
    return dataSource;
  }

  public void setDataSource(DataSource dataSource)
  {
    this.dataSource = dataSource;
  }
}
