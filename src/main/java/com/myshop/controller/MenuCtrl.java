package com.myshop.controller;

import com.myshop.controller.vo.MenuSaveVO;
import com.myshop.controller.vo.MenuVO;
import com.myshop.controller.vo.RestResult;
import com.myshop.service.IMenuSvc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuCtrl {

  @Autowired
  private IMenuSvc menuSvc;

  @PostMapping("/saveMenu")
  public RestResult saveMenu(@RequestBody MenuSaveVO menuSaveVO) {

    menuSvc.saveMenu(menuSaveVO);

    return new RestResult(true);
  }

  @GetMapping("/getMenus")
  public RestResult getMenus() {

    List<MenuVO> menus = menuSvc.getMenus();

    return new RestResult(true, menus);
  }

  @GetMapping("/getParents")
  public RestResult getParents() {
    return new RestResult(true, menuSvc.getParents());
  }
}
