package com.myshop.service.impl;

import com.myshop.dao.IUserDao;
import com.myshop.dao.dto.UserDTO;
import com.myshop.dao.dto.UserPredicate;
import com.myshop.dao.model.User;
import com.myshop.dao.repo.IUserRepo;
import com.myshop.service.IUserSvc;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserSvcImpl implements IUserSvc {


  @Autowired
  private IUserRepo userRepo;

  @Autowired
  private IUserDao userDao;

  @Override
  public Optional<User> findUserById(String id) {
    return userRepo.findById(id);
  }

  @Override
  public Page<UserDTO> getUserPage(UserPredicate userPredicate, Pageable pageable) {
    return userDao.queryUserPage(userPredicate, pageable);
  }
}
