package org.example.data;

import org.example.domain.Token;

public interface TokenRepository extends ModelRepository<Token>
{
  Token findByValue(String value);
}
