package com.myshop.core.exception;

import java.util.Arrays;
import java.util.List;

public class ShopException extends RuntimeException{

  private static final long serialVersionUID = 6739048141076705961L;

  private String msgCode;

  private List<String> msgStringList;

  public ShopException(String msgCode, String... msgParams) {
    this.msgCode = msgCode;
    this.msgStringList = Arrays.asList(msgParams);
  }

  public String getMsgCode() {
    return msgCode;
  }

  public List<String> getMsgStringList() {
    return msgStringList;
  }
}
