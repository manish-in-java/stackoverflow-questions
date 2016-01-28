package org.example;

public class CarFactory
{
  private static final CarFactory INSTANCE = new CarFactory();

  private CarFactory()
  {
  }

  public static CarFactory getInstance()
  {
    return INSTANCE;
  }

  public Car createCar(final String make)
  {
    return new Car(make);
  }
}
