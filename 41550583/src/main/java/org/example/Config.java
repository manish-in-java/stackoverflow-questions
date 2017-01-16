package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories
public class Config
{
  @Bean
  BasicDataSource dataSource()
  {
    BasicDataSource ans = new BasicDataSource();
    ans.setDriverClassName("org.h2.Driver");
    ans.setUrl("jdbc:h2:mem:stackoverflow");

    return ans;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
  {
    LocalContainerEntityManagerFactoryBean ans = new LocalContainerEntityManagerFactoryBean();
    ans.setDataSource(dataSource());
    ans.setJpaVendorAdapter(jpaVendorAdapter());
    ans.setPackagesToScan(getClass().getPackage().getName());

    return ans;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter()
  {
    HibernateJpaVendorAdapter ans = new HibernateJpaVendorAdapter();
    ans.setShowSql(false);
    ans.setGenerateDdl(true);
    ans.setDatabase(Database.H2);

    return ans;
  }

  @Bean
  public PlatformTransactionManager transactionManager()
  {
    JpaTransactionManager ans = new JpaTransactionManager();
    ans.setEntityManagerFactory(entityManagerFactory().getObject());

    return ans;
  }
}
