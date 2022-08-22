package com.myshop.service.impl;

import com.myshop.controller.vo.MenuSaveVO;
import com.myshop.controller.vo.MenuVO;
import com.myshop.dao.model.Menu;
import com.myshop.dao.model.QLunch;
import com.myshop.dao.repo.IMenuRepo;
import com.myshop.service.IMenuSvc;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuSvcImpl implements IMenuSvc {


  @Autowired
  private IMenuRepo menuRepo;

  @Override
  public void saveMenu(MenuSaveVO menuSaveVO) {
    Menu menu = new Menu();
    BeanUtils.copyProperties(menuSaveVO, menu);

    Optional<Menu> menuOptional = menuRepo.findById(menu.getName());

    if (menuOptional.isPresent()) {
      menuRepo.saveAndFlush(menu);
    }else{
      menuRepo.save(menu);
    }
  }

  @Override
  public List<MenuVO> getMenus() {
    List<Menu> menus = menuRepo.findAll();

    List<MenuVO> menuList = menus.stream()
        .filter(menu -> "menu".equals(menu.getType()))
        .filter(menu -> BooleanUtils.isTrue(menu.getEnable()))
        .map(menu -> new MenuVO(menu.getName(), menu.getType(), menu.getTitle(), menu.getEnable()))
        .collect(Collectors.toList());

    Map<String, List<Menu>> parentMap = menus
        .stream()
        .filter(menu -> StringUtils.isNotBlank(menu.getParent()))
        .collect(Collectors.groupingBy(Menu::getParent, Collectors.toList()));

    menuList.forEach(menuVO -> {
      List<Menu> subMenus = parentMap.get(menuVO.getName());
      if (CollectionUtils.isNotEmpty(subMenus)) {
        List<MenuVO> subMenuVOs = subMenus.stream().map(menu -> {
          MenuVO menuVO1 = new MenuVO();
          BeanUtils.copyProperties(menu, menuVO1);
          return menuVO1;
        }).collect(Collectors.toList());
        menuVO.setSubMenus(subMenuVOs);
      }
    });
    return menuList;
  }

  @Override
  public List<MenuVO> getParents() {
    return menuRepo.findAllByType("menu")
        .stream()
        .filter(menu -> BooleanUtils.isTrue(menu.getEnable()))
        .map(menu -> {
          MenuVO menuVO = new MenuVO();
          BeanUtils.copyProperties(menu, menuVO);
          return menuVO;
        }).collect(Collectors.toList());
  }
}
