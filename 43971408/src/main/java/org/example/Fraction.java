package org.example;

import java.math.BigInteger;

public class Fraction implements MatrixElement<Fraction>
{
  private final BigInteger numerator;
  private final BigInteger denominator;

  public Fraction(final int numerator, final int denominator)
  {
    this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
  }

  public Fraction(final BigInteger numerator, final BigInteger denominator)
  {
    final BigInteger gcd = gcd(numerator, denominator);

    this.numerator = isOne(gcd) ? numerator : numerator.divide(gcd);
    this.denominator = isOne(gcd) ? denominator : denominator.divide(gcd);
  }

  public Fraction add(final Fraction that)
  {
    return new Fraction(this.numerator.multiply(that.denominator).add(this.denominator.multiply(that.numerator))
        , this.denominator.multiply(that.denominator));
  }

  private Pair<BigInteger, BigInteger> extendedEuclideanDivision(final BigInteger a, final BigInteger b)
  {
    if (isNegative(a))
    {
      final Pair<BigInteger, BigInteger> t = extendedEuclideanDivision(negate(a), b);

      return new Pair(negate(t.item1), t.item2);
    }
    else if (isNegative(b))
    {
      final Pair<BigInteger, BigInteger> t = extendedEuclideanDivision(a, negate(b));

      return new Pair(t.item1, negate(t.item2));
    }
    else if (isZero(b))
    {
      return new Pair(BigInteger.ONE, BigInteger.ZERO);
    }

    final BigInteger q = a.divide(b), r = a.remainder(b);

    final Pair<BigInteger, BigInteger> t = extendedEuclideanDivision(b, r);

    return new Pair(t.item2, t.item1.subtract(q.multiply(t.item2)));
  }

  private BigInteger gcd(final Fraction fraction)
  {
    return gcd(fraction.numerator, fraction.denominator);
  }

  private BigInteger gcd(final BigInteger numerator, final BigInteger denominator)
  {
    final Pair<BigInteger, BigInteger> t = extendedEuclideanDivision(numerator, denominator);

    return numerator.multiply(t.item1)
                    .add(denominator.multiply(t.item2));
  }

  private boolean isNegative(final BigInteger number)
  {
    return number.compareTo(BigInteger.ZERO) < 0;
  }

  private boolean isOne(final BigInteger number)
  {
    return number.equals(BigInteger.ONE);
  }

  private boolean isZero(final BigInteger number)
  {
    return number.equals(BigInteger.ZERO);
  }

  private BigInteger negate(final BigInteger number)
  {
    return number.multiply(BigInteger.valueOf(-1));
  }

  private static class Pair<T, U>
  {
    private final T item1;
    private final U item2;

    private Pair(final T item1, final U item2)
    {
      this.item1 = item1;
      this.item2 = item2;
    }
  }

  public String toString()
  {
    return isOne(denominator)
           ? numerator.toString()
           : String.format("%d/%d", numerator, denominator);
  }
}
