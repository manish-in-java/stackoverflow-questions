package org.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

public class FloatBenchmark extends NumberBenchmark
{
  @Benchmark
  @Fork(0)
  @Measurement(iterations = 10)
  @Warmup(iterations = 10)
  public void boxed() throws Exception
  {
    final Float number = getFloat();

    final Float square = number * number;
  }

  @Benchmark
  @Fork(0)
  @Measurement(iterations = 10)
  @Warmup(iterations = 10)
  public void unboxed() throws Exception
  {
    final float number = getFloat();

    final float square = number * number;
  }
}
