package org.example.data;

import org.example.domain.ZTree;

import java.util.List;

public interface ZTreeRepository extends ModelRepository<ZTree>
{
  List<ZTree> findAllByOrderByTid();
}
