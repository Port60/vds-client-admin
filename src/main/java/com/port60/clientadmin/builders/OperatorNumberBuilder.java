package com.port60.clientadmin.builders;

import com.port60.clientadmin.model.Country;
import com.port60.clientadmin.model.OperatorFirm;
import com.port60.clientadmin.model.OperatorNumber;
import java.time.LocalDateTime;
import org.springframework.expression.spel.ast.Operator;

public final class OperatorNumberBuilder {

  private LocalDateTime created;
  private String createdByUser;
  private LocalDateTime lastModified;
  private String lastUpdatedByUser;
  private Country country;
  private String number;
  private OperatorFirm operatorFirm;

  private OperatorNumberBuilder() {
  }

  public static OperatorNumberBuilder anOperatorNumber() {
    return new OperatorNumberBuilder();
  }

  public OperatorNumberBuilder withCreated(LocalDateTime created) {
    this.created = created;
    return this;
  }

  public OperatorNumberBuilder withCreatedByUser(String createdByUser) {
    this.createdByUser = createdByUser;
    return this;
  }

  public OperatorNumberBuilder withLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  public OperatorNumberBuilder withLastUpdatedByUser(String lastUpdatedByUser) {
    this.lastUpdatedByUser = lastUpdatedByUser;
    return this;
  }

  public OperatorNumberBuilder withCountry(Country country) {
    this.country = country;
    return this;
  }

  public OperatorNumberBuilder withNumber(String number) {
    this.number = number;
    return this;
  }

  public OperatorNumberBuilder withOperatorFirm(OperatorFirm operatorFirm) {
    this.operatorFirm = operatorFirm;
    return this;
  }

  public OperatorNumber build() {
    OperatorNumber operatorNumber = new OperatorNumber();
    operatorNumber.setCreated(created ==null ? LocalDateTime.now() : created);
    operatorNumber.setCreatedByUser(createdByUser == null ? "System" : createdByUser);
    operatorNumber.setLastModified(lastModified == null ? LocalDateTime.now(): lastModified);
    operatorNumber.setLastUpdatedByUser(lastUpdatedByUser == null ? "System" : lastUpdatedByUser);
    operatorNumber.setCountry(country);
    operatorNumber.setNumber(number);
    operatorNumber.setOperatorFirm(operatorFirm);
    return operatorNumber;
  }
}
