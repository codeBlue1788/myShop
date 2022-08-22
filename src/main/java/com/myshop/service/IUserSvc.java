package com.myshop.service;

import com.myshop.dao.dto.UserDTO;
import com.myshop.dao.dto.UserPredicate;
import com.myshop.dao.model.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserSvc {

  Optional<User> findUserById(String id);

  Page<UserDTO> getUserPage(UserPredicate userPredicate, Pageable pageable);
}
