package com.myshop.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "ID")
  private String id;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "NAME")
  private String username;


  @Column(name = "SEX")
  private String sex;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "CREATE_DATE")
  private LocalDateTime createDate;
}
