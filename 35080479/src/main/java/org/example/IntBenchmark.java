package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

public class IntBenchmark extends NumberBenchmark
{
  @Benchmark
  @Fork(0)
  @Measurement(iterations = 10)
  @Warmup(iterations = 10)
  public void boxed() throws Exception
  {
    final Integer number = getInt();

    final Integer square = number * number;
  }

  @Benchmark
  @Fork(0)
  @Measurement(iterations = 10)
  @Warmup(iterations = 10)
  public void unboxed() throws Exception
  {
    final int number = getInt();

    final int square = number * number;
  }
}
