package com.myshop.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryFactoryConfig {

  @Bean
  public JPAQueryFactory jpqQuery(EntityManager entityManager) {
    return new JPAQueryFactory(entityManager);
  }
}
