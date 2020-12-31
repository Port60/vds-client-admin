package com.port60.clientadmin.exception;


import lombok.Getter;

public class VDSRuntimeException extends RuntimeException {

  @Getter
  private ExceptionStatus exceptionStatus;

  public VDSRuntimeException(String message, ExceptionStatus status) {
    super(message);
    this.exceptionStatus = status;
  }
}
