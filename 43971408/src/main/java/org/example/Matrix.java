package org.example;

import java.util.ArrayList;
import java.util.List;

public class Matrix<T extends MatrixElement<T>>
{
  private final int           columns;
  private final List<List<T>> elements;
  private final int           rows;

  public Matrix(final List<List<T>> elements)
  {
    this.columns = elements.get(0).size();
    this.elements = elements;
    this.rows = elements.size();
  }

  public Matrix<T> add(final Matrix<T> that)
  {
    if (this.rows != that.rows || this.columns != that.columns)
    {
      throw new IllegalArgumentException("Matrices must be the same size.");
    }

    final List<List<T>> result = new ArrayList<>(rows);
    for (int row = 0; row < rows; ++row)
    {
      final List<T> values = new ArrayList<>(columns);

      for (int column = 0; columns < columns; ++column)
      {
        values.set(column, this.elements.get(row).get(column).add(that.elements.get(row).get(column)));
      }

      result.set(row, values);
    }

    return new Matrix<T>(result);
  }
}
