package com.myshop.core.exception;

import com.myshop.controller.vo.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice
@RestController
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
  public final ResponseEntity<RestResult> handleShopException(ShopException ex) {
    return new ResponseEntity<>(new RestResult(ex.getMsgCode(), ex.getMsgStringList(), null,false),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
