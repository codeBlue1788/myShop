package com.myshop.controller.vo;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class RestResult {

  private boolean isSuccess;
  /** 訊息代碼 */
  private String msgCode;
  /** Rest 回傳物件 */
  private Object restData;
  /** 訊息參數 */
  private List<String> msgStringList;

  public RestResult(String msgCode, List<String> msg, Object restData, boolean isSuccess) {
    this.msgCode = msgCode;
    this.msgStringList = new ArrayList<>();
    this.msgStringList.addAll(msg);
    this.restData = restData;
    this.isSuccess = isSuccess;
  }

  public RestResult(boolean isSuccess, Object restData) {
    this.isSuccess = isSuccess;
    this.restData = restData;
  }

  public RestResult(boolean isSuccess) {
    this.isSuccess = isSuccess;
  }
}
