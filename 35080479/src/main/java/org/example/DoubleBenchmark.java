package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

public class DoubleBenchmark extends NumberBenchmark
{
  @Benchmark
  @Fork(0)
  @Measurement(iterations = 10)
  @Warmup(iterations = 10)
  public void boxed() throws Exception
  {
    final Double number = getDouble();

    final Double square = number * number;
  }

  @Benchmark
  @Fork(0)
  @Measurement(iterations = 10)
  @Warmup(iterations = 10)
  public void unboxed() throws Exception
  {
    final double number = getDouble();

    final double square = number * number;
  }
}
