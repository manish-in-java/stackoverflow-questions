package org.example;

import java.security.SecureRandom;
import java.util.Random;

public abstract class NumberBenchmark
{
  private static final Random RANDOM = new SecureRandom();

  protected double getDouble()
  {
    return RANDOM.nextDouble();
  }

  protected float getFloat()
  {
    return RANDOM.nextFloat();
  }

  protected int getInt()
  {
    return RANDOM.nextInt();
  }
}
