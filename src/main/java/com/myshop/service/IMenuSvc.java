package com.myshop.service;

import com.myshop.controller.vo.MenuSaveVO;
import com.myshop.controller.vo.MenuVO;
import com.myshop.dao.model.Menu;
import java.util.List;

public interface IMenuSvc {

  void saveMenu(MenuSaveVO menuSaveVO);

  List<MenuVO> getMenus();

  List<MenuVO> getParents();
}
