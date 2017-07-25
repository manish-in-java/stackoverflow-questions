package org.example.data;

import org.example.domain.Router;

import java.util.List;

public interface RouterRepository extends ModelRepository<Router>
{
  List<Router> findAllByRouterDetailsObjectType(Character objectType);
}
