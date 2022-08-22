package com.myshop.dao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "menu")
public class Menu implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "MENU_NAME")
  private String name;

  @Column(name = "MENU_PATH")
  private String path;

  @Column(name = "MENU_PARENT")
  private String parent;

  @Column(name = "MENU_TITLE")
  private String title;

  @Column(name = "MENU_TYPE")
  private String type;

  @Column(name = "MENU_ENABLE")
  private Boolean enable;
}
