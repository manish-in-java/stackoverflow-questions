package org.example.data;

import org.example.domain.Algo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgoRepository extends JpaRepository<Algo, Long>
{
}
