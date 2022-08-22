package com.myshop.dao;

import com.myshop.dao.dto.UserDTO;
import com.myshop.dao.dto.UserPredicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserDao {

  Page<UserDTO> queryUserPage(UserPredicate userPredicate, Pageable pageable);
}
