package com.port60.clientadmin.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice   extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value
      = { VDSRuntimeException.class })
  protected ResponseEntity<Object> handleVdsException(
      VDSRuntimeException ex, WebRequest request) {
    VdsErrorStatus status = new VdsErrorStatus(ex.getExceptionStatus().getCode(),ex.getMessage());
    return handleExceptionInternal(ex, status,
        new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }



  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ValidationErrorResponse handleConstraintValidationException(
      ConstraintViolationException e) {
    ValidationErrorResponse error = new ValidationErrorResponse();
    for (ConstraintViolation violation : e.getConstraintViolations()) {
      error.getViolations().add(
          new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
    }
    return error;
  }



  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    ValidationErrorResponse error = new ValidationErrorResponse();
    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      error.getViolations().add(
          new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
    }
    return new ResponseEntity<>(error, headers, status);
  }


}
