package com.myshop.controller;

import com.myshop.controller.vo.RestResult;
import com.myshop.controller.vo.UserVO;
import com.myshop.dao.dto.UserPredicate;
import com.myshop.service.ISysParamSvc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SysParamCtrl {


  @Autowired
  private ISysParamSvc sysParamSvc;

  @GetMapping("/getSysParam")
  public RestResult getSysParam() {
    return new RestResult(true, sysParamSvc.getAllSysParam());
  }
}
