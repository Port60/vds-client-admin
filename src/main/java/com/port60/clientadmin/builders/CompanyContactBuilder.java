package com.port60.clientadmin.builders;

import com.port60.clientadmin.dto.RegistrationDto;
import com.port60.clientadmin.model.Company;
import com.port60.clientadmin.model.CompanyContact;
import com.port60.clientadmin.model.Contact;
import java.time.LocalDateTime;
import java.util.Optional;

public final class CompanyContactBuilder {

  private LocalDateTime created;
  private String createdByUser;
  private LocalDateTime lastModified;
  private String lastUpdatedByUser;
  private Company company;
  private Contact contact;
  private String position;
  private Boolean primaryCompanyContact;
  private Boolean active;
  private LocalDateTime startDate;
  private LocalDateTime endDate;

  private CompanyContactBuilder() {
  }

  public static CompanyContactBuilder aCompanyContact() {
    return new CompanyContactBuilder();
  }

  public CompanyContactBuilder withCreated(LocalDateTime created) {
    this.created = created;
    return this;
  }

  public CompanyContactBuilder withCreatedByUser(String createdByUser) {
    this.createdByUser = createdByUser;
    return this;
  }

  public CompanyContactBuilder withLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  public CompanyContactBuilder withLastUpdatedByUser(String lastUpdatedByUser) {
    this.lastUpdatedByUser = lastUpdatedByUser;
    return this;
  }


  public CompanyContactBuilder withCompany(Company company) {
    this.company = company;
    return this;
  }

  public CompanyContactBuilder withContact(Contact contact) {
    this.contact = contact;
    return this;
  }

  public CompanyContactBuilder withPosition(String position) {
    this.position = position;
    return this;
  }

  public CompanyContactBuilder withPrimaryCompanyContact(Boolean primaryCompanyContact) {
    this.primaryCompanyContact = primaryCompanyContact;
    return this;
  }

  public CompanyContactBuilder withActive(Boolean active) {
    this.active = active;
    return this;
  }

  public CompanyContactBuilder withStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  public CompanyContactBuilder withEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  public CompanyContactBuilder fromRegistrationDto(RegistrationDto registrationdto){

    this.position=registrationdto.getContactPosition();
    this.primaryCompanyContact = true;

    return this;
  }

  public CompanyContact build() {
    CompanyContact companyContact = new CompanyContact();

    companyContact.setCreated(Optional.ofNullable(created).orElse(LocalDateTime.now()));
    companyContact.setCreatedByUser(Optional.ofNullable(createdByUser).orElse("System"));
    companyContact.setLastModified(Optional.ofNullable(lastModified).orElse(LocalDateTime.now()));
    companyContact.setLastUpdatedByUser(Optional.ofNullable(lastUpdatedByUser).orElse("System"));

    companyContact.setCompany(company);
    companyContact.setContact(contact);
    companyContact.setPosition(position);
    companyContact.setPrimaryCompanyContact(primaryCompanyContact);
    companyContact.setActive(active);
    companyContact.setStartDate(startDate == null ? LocalDateTime.now() : startDate);
    companyContact.setEndDate(endDate);
    return companyContact;
  }
}
