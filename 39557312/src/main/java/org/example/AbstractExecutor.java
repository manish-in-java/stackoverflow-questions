package org.example;

public abstract class AbstractExecutor implements IExecutor
{
  private IInputPropertyBean  input;
  private IOutputPropertyBean output;

  public AbstractExecutor(IInputPropertyBean input, IOutputPropertyBean output)
  {
    this.input = input;
    this.output = output;
  }

  public IOutputPropertyBean execute()
  {
    return output;
  }
}
