package com.myshop.controller.vo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {

  private String name;

  private String path;

  private String type;

  private String parent;

  private String title;

  private List<MenuVO> subMenus;

  private Boolean enable;


  public MenuVO(String name, String type, String title, Boolean enable) {
    this.name = name;
    this.type = type;
    this.title = title;
    this.enable = enable;
  }
}
