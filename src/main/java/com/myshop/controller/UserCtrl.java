package com.myshop.controller;

import com.myshop.controller.vo.RestResult;
import com.myshop.controller.vo.UserVO;
import com.myshop.dao.dto.UserPredicate;
import com.myshop.service.IUserSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserCtrl {

  @Autowired
  private IUserSvc userSvc;

  @GetMapping("queryUserPage")
  public RestResult queryUserPage(UserVO userVO, Pageable pageable) {
    log.info("userVO:{}", userVO);
    UserPredicate userPredicate = new UserPredicate();
    BeanUtils.copyProperties(userVO, userPredicate);
    return new RestResult(true, userSvc.getUserPage(userPredicate, pageable));
  }
}
