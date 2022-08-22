package com.myshop.dao.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sys_param")
public class SysParam implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "CODE")
  private String code;

  @Column(name = "CODE_NAME")
  private String codeName;

  @Column(name = "CODE_VALUE")
  private String codeValue;
}
