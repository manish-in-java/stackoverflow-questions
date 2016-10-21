package org.example.data;

import org.example.domain.QReport;
import org.example.domain.Report;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ReportRepositoryTest
{
  @Autowired
  private ReportRepository reportRepository;

  @Before
  public void setup()
  {
    for (int i = 0; i < 10; ++i)
    {
      reportRepository.saveAndFlush(new Report(Integer.toString(i)));
    }
  }

  @Test
  public void testFindAll()
  {
    final Iterable<Report> reports = reportRepository.findAll(QReport.report.isNotNull(), new Sort("name"));

    assertNotNull(reports);
    reports.forEach(report ->
                    {
                      assertNotNull(report);
                      assertNotNull(report.getID());
                      assertNotNull(report.getName());
                    });
  }
}
