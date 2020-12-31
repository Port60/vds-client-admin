package com.port60.clientadmin.exception;

import lombok.Data;

@Data
public class VdsErrorStatus {

  private final Integer errorCode;

  private final String message;


}