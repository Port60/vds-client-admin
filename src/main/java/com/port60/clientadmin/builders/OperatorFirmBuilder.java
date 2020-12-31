package com.port60.clientadmin.builders;

import com.port60.clientadmin.dto.RegistrationDto;
import com.port60.clientadmin.model.Address;
import com.port60.clientadmin.model.Company;
import com.port60.clientadmin.model.OperatorFirm;
import com.port60.clientadmin.model.OperatorNumber;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public final class OperatorFirmBuilder {


  private LocalDateTime created;
  private String createdByUser;
  private LocalDateTime lastModified;
  private String lastUpdatedByUser;

  private String name;
  private Address address;
  private String operatorLicence;
  private Company company;
  private Boolean evidenceUpToDate;
  private List<OperatorNumber> operatorNumberList;

  private OperatorFirmBuilder() {
  }

  public static OperatorFirmBuilder anOperatorFirm() {
    return new OperatorFirmBuilder();
  }



  public OperatorFirmBuilder withCreated(LocalDateTime created) {
    this.created = created;
    return this;
  }

  public OperatorFirmBuilder withCreatedByUser(String createdByUser) {
    this.createdByUser = createdByUser;
    return this;
  }

  public OperatorFirmBuilder withLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  public OperatorFirmBuilder withLastUpdatedByUser(String lastUpdatedByUser) {
    this.lastUpdatedByUser = lastUpdatedByUser;
    return this;
  }

  public OperatorFirmBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public OperatorFirmBuilder withAddress(Address address) {
    this.address = address;
    return this;
  }

  public OperatorFirmBuilder withOperatorLicence(String operatorLicence) {
    this.operatorLicence = operatorLicence;
    return this;
  }

  public OperatorFirmBuilder withCompany(Company company) {
    this.company = company;
    return this;
  }

  public OperatorFirmBuilder withEvidenceUpToDate(Boolean evidenceUpToDate) {
    this.evidenceUpToDate = evidenceUpToDate;
    return this;
  }

  public OperatorFirmBuilder withOperatorNumberList(List<OperatorNumber> operatorNumberList){
    this.operatorNumberList = operatorNumberList;
    return this;
  }

  public OperatorFirmBuilder fromOperatorFirmDto(RegistrationDto registrationDto) {
    this.name = registrationDto.getName();
    this.operatorLicence = registrationDto.getOperatorLicence();

    return this;
  }
  public OperatorFirm build() {
    OperatorFirm operatorFirm = new OperatorFirm();

    operatorFirm.setCreated(Optional.ofNullable(created).orElse(LocalDateTime.now()));
    operatorFirm.setCreatedByUser(Optional.ofNullable(createdByUser).orElse("System"));
    operatorFirm.setLastModified(Optional.ofNullable(lastModified).orElse(LocalDateTime.now()));
    operatorFirm.setLastUpdatedByUser(Optional.ofNullable(lastUpdatedByUser).orElse("System"));
    operatorNumberList.forEach(opNumList -> opNumList.setOperatorFirm(operatorFirm));
    operatorFirm.setOperatorNumberList(operatorNumberList);
    operatorFirm.setName(name);
    operatorFirm.setAddress(address);
    operatorFirm.setOperatorLicence(operatorLicence);
    operatorFirm.setCompany(company);
    operatorFirm.setEvidenceUpToDate(evidenceUpToDate);
    return operatorFirm;
  }
}
