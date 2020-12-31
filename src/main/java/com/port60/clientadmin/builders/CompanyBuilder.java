package com.port60.clientadmin.builders;

import com.port60.clientadmin.dto.RegistrationDto;
import com.port60.clientadmin.model.Address;
import com.port60.clientadmin.model.Company;
import java.time.LocalDateTime;

public final class CompanyBuilder {


  private String companyName;
  private String companyRegNumber;
  private Address address;
  private Boolean active;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

  private CompanyBuilder() {
  }

  public static CompanyBuilder aCompany() {
    return new CompanyBuilder();
  }



  public CompanyBuilder withCompanyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  public CompanyBuilder withCompanyRegNumber(String companyRegNumber) {
    this.companyRegNumber = companyRegNumber;
    return this;
  }

  public CompanyBuilder withAddress(Address address) {
    this.address = address;
    return this;
  }

  public CompanyBuilder withActive(Boolean active) {
    this.active = active;
    return this;
  }

  public CompanyBuilder withStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  public CompanyBuilder withEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  public CompanyBuilder fromOperatorFirmDto(RegistrationDto registrationDto){
    this.companyName = registrationDto.getName();
    this.companyRegNumber = registrationDto.getCompanyRegNumber();

    return this;
  }

  public Company build() {
    Company company = new Company();

    company.setCreated(LocalDateTime.now());
    company.setCreatedByUser("System");
    company.setLastModified(LocalDateTime.now());
    company.setLastUpdatedByUser("System");

    company.setCompanyName(companyName);
    company.setCompanyRegNumber(companyRegNumber);
    company.setAddress(address);
    company.setActive(active);
    company.setStartDate(startDate);
    company.setEndDate(endDate);
    return company;
  }
}
