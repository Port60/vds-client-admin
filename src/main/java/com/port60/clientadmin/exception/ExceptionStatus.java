package com.port60.clientadmin.exception;

public enum ExceptionStatus {

  // Company/Operator Statuses

  COMPANY_EXISTS(1001),
  OPERATOR_FIRM_EXISTS(1002),

  COUNTRY_UNSUPPORTED(2000);


  private int code;
  ExceptionStatus(int code){
    this.code = code;
  }

  public Integer getCode(){
    return this.code;
  }

}
