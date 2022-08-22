package com.myshop.dao.impl;

import com.myshop.dao.IUserDao;
import com.myshop.dao.dto.UserDTO;
import com.myshop.dao.dto.UserPredicate;
import com.myshop.dao.model.QUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

  @Autowired
  private JPQLQueryFactory queryFactory;

  @Override
  public Page<UserDTO> queryUserPage(UserPredicate userPredicate, Pageable pageable) {
    QUser qUser = QUser.user;

    BooleanBuilder predicate = this.buildPredicate(userPredicate, qUser);

    QueryResults<UserDTO> result = queryFactory.select(
            Projections.bean(UserDTO.class, qUser.id, qUser.username, qUser.sex, qUser.email,
                qUser.password))
        .from(qUser)
        .where(predicate)
        .offset(pageable.getOffset())
        .limit(pageable.getPageSize())
        .fetchResults();

    return new PageImpl<>(result.getResults(), pageable, result.getTotal());
  }

  private BooleanBuilder buildPredicate(UserPredicate userPredicate, QUser qUser) {
    BooleanBuilder predicate = new BooleanBuilder();

    if (StringUtils.isNotBlank(userPredicate.getId())) {
      predicate.and(qUser.id.eq(userPredicate.getId()));
    }

    if (StringUtils.isNotBlank(userPredicate.getUsername())) {
      predicate.and(qUser.username.eq(userPredicate.getUsername()));
    }
    if (StringUtils.isNotBlank(userPredicate.getSex())) {
      predicate.and(qUser.sex.eq(userPredicate.getSex()));
    }

    return predicate;
  }
}
