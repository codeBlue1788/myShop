package com.myshop.controller;

import com.myshop.controller.vo.RestResult;
import com.myshop.controller.vo.UserVO;
import com.myshop.core.exception.ShopException;
import com.myshop.dao.model.User;
import com.myshop.service.IUserSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Slf4j
public class Login {

  @Autowired
  private IUserSvc userSvc;

  @GetMapping("/validateUser")
  public UserVO validateUser(String username, String password) {
    User user = userSvc.findUserById("a12345").orElseThrow(() -> new ShopException("E001", "查無ID"));
    log.info("User name : {}", username);
    log.info("User password : {}", password);
    log.info("User info : {}", user);
    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(user, userVO);
    return userVO;
  }

  @PostMapping("/validateUserPost")
  public RestResult validateUserPost(@RequestBody UserVO userVO) {
    log.info("UserVO : {}", userVO);

    User user = userSvc.findUserById(userVO.getId())
        .orElseThrow(() -> new ShopException("E001", "查無ID"));
    UserVO userVO2 = new UserVO();
    BeanUtils.copyProperties(user, userVO2);
    return new RestResult(true,userVO2);
  }
}
