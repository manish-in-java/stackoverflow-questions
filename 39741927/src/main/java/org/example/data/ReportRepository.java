package org.example.data;

import com.querydsl.core.types.Predicate;
import org.example.domain.Report;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long>, QueryDslPredicateExecutor<Report>
{
  List<Report> findAllBy(Predicate predicate, Sort sort);
}
