package com.port60.clientadmin.builders;

import com.port60.clientadmin.dto.RegistrationDto;
import com.port60.clientadmin.model.Contact;
import java.time.LocalDateTime;
import java.util.Optional;

public final class ContactBuilder {

  private LocalDateTime created;
  private String createdByUser;
  private LocalDateTime lastModified;
  private String lastUpdatedByUser;
  private String title;
  private String firstName;
  private String lastName;
  private String telephoneNumber;
  private String email;

  private ContactBuilder() {
  }

  public static ContactBuilder aContact() {
    return new ContactBuilder();
  }

  public ContactBuilder withCreated(LocalDateTime created) {
    this.created = created;
    return this;
  }

  public ContactBuilder withCreatedByUser(String createdByUser) {
    this.createdByUser = createdByUser;
    return this;
  }

  public ContactBuilder withLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  public ContactBuilder withLastUpdatedByUser(String lastUpdatedByUser) {
    this.lastUpdatedByUser = lastUpdatedByUser;
    return this;
  }

  public ContactBuilder withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactBuilder withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactBuilder withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactBuilder withTelephoneNumber(String telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
    return this;
  }

  public ContactBuilder withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactBuilder fromRegistrationDto(RegistrationDto registrationDto) {
    this.title = registrationDto.getContactTitle();
    this.firstName = registrationDto.getContactFirstName();
    this.lastName = registrationDto.getContactLastName();
    this.email = registrationDto.getContactEmail();
    this.telephoneNumber = registrationDto.getContactPhoneNumber();
    return this;
  }

  public Contact build() {
    Contact contact = new Contact();
    contact.setCreated(Optional.ofNullable(created).orElse(LocalDateTime.now()));
    contact.setCreatedByUser(Optional.ofNullable(createdByUser).orElse("System"));
    contact.setLastModified(Optional.ofNullable(lastModified).orElse(LocalDateTime.now()));
    contact.setLastUpdatedByUser(Optional.ofNullable(lastUpdatedByUser).orElse("System"));
    contact.setTitle(title);
    contact.setFirstName(firstName);
    contact.setLastName(lastName);
    contact.setTelephoneNumber(telephoneNumber);
    contact.setEmail(email);
    return contact;
  }
}
