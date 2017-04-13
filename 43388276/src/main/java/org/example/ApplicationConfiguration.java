package org.example;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@ComponentScan
@Configuration
@EnableJpaRepositories(basePackages = "org.example.data")
public abstract class ApplicationConfiguration
{
  @Bean(destroyMethod = "close")
  public DataSource dataSource()
  {
    final HikariDataSource bean = new HikariDataSource();
    bean.setAutoCommit(false);
    bean.setConnectionTimeout(300);
    bean.setDriverClassName("org.h2.Driver");
    bean.setJdbcUrl("jdbc:h2:mem:stackoverflow");
    bean.setMaximumPoolSize(5);
    bean.setMinimumIdle(1);
    bean.setPassword("");
    bean.setTransactionIsolation("TRANSACTION_READ_COMMITTED");
    bean.setUsername("sa");
    bean.setValidationTimeout(2000);

    return bean;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory()
  {
    final LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    bean.setDataSource(dataSource());
    bean.setJpaVendorAdapter(jpaVendorAdapter());
    bean.setPackagesToScan("org.example.domain");

    return bean;
  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter()
  {
    final HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
    bean.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
    bean.setGenerateDdl(true);
    bean.setShowSql(true);

    return bean;
  }

  @Bean
  public PlatformTransactionManager transactionManager()
  {
    final JpaTransactionManager bean = new JpaTransactionManager();
    bean.setEntityManagerFactory(entityManagerFactory().getObject());

    return bean;
  }
}
