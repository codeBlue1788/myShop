package com.myshop.controller.vo;

import lombok.Data;

@Data
public class MenuSaveVO {

  private String name;

  private String path;

  private String type;

  private String parent;

  private String title;

  private boolean enable;
}
