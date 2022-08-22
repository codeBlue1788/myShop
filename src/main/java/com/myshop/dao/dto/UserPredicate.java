package com.myshop.dao.dto;

import lombok.Data;

@Data
public class UserPredicate {

  private String id;

  private String password;

  private String username;

  private String sex;

  private String email;
}
