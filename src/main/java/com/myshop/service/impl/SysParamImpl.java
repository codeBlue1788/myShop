package com.myshop.service.impl;

import com.myshop.dao.model.SysParam;
import com.myshop.dao.repo.ISysParamRepo;
import com.myshop.service.ISysParamSvc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysParamImpl implements ISysParamSvc {

  @Autowired
  private ISysParamRepo sysParamRepo;

  @Override
  public List<SysParam> getAllSysParam() {
    return sysParamRepo.findAll();
  }
}
