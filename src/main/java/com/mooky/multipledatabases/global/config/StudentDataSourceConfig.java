package com.mooky.multipledatabases.global.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

// (1) declare which packages to attach this data source
// (2) link EntityManagerFactory and TransactionManager
@EnableJpaRepositories(
  basePackages = {"com.mooky.multipledatabases.domain.student"},
  entityManagerFactoryRef = "studentEntityManagerFactory",
  transactionManagerRef = "studentTransactionManager"
)
@Configuration
public class StudentDataSourceConfig {

  // (3) create datasource from properties file 
  // (4) declare Primary as this will be the default data source
  @Primary
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.student")
  DataSource studentDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Primary // needs primary too
  @Bean
  LocalContainerEntityManagerFactoryBean studentEntityManagerFactory(
      EntityManagerFactoryBuilder builder,
      @Qualifier("studentDataSource") DataSource dataSource) {
    return builder
        .dataSource(dataSource)
        .packages("com.mooky.multipledatabases.domain")
        .persistenceUnit("student")
        .build();
  }

  @Bean
  PlatformTransactionManager studentTransactionManager(
      @Qualifier("studentEntityManagerFactory") EntityManagerFactory localEntityManagerFactory) {
    return new JpaTransactionManager(localEntityManagerFactory);
  }

}
