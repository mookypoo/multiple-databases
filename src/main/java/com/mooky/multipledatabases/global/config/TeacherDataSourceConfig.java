package com.mooky.multipledatabases.global.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = { "com.mooky.multipledatabases.domain.teacher" },
    entityManagerFactoryRef = "teacherEntityManagerFactory",
    transactionManagerRef = "teacherTransactionManager"
  )
public class TeacherDataSourceConfig {
  
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.teacher")
  DataSource teacherDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  LocalContainerEntityManagerFactoryBean teacherEntityManagerFactory(
      EntityManagerFactoryBuilder builder,
      @Qualifier("teacherDataSource") DataSource dataSource) {
    return builder
        .dataSource(dataSource)
        .packages("com.mooky.multipledatabases.domain")
        .persistenceUnit("teacher")
        .build();
  }

  @Bean
  PlatformTransactionManager teacherTransactionManager(
      @Qualifier("teacherEntityManagerFactory") EntityManagerFactory teacherEntityManagerFactory) {
    return new JpaTransactionManager(teacherEntityManagerFactory);
  }
}
