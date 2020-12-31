package com.port60.clientadmin.builders;

import com.port60.clientadmin.dto.RegistrationDto;
import com.port60.clientadmin.model.Address;
import java.time.LocalDateTime;

public final class AddressBuilder {

  private String postCode;
  private String addressLine1;
  private String addressLine2;
  private String addressLine3;
  private String county;
  private String country;

  private AddressBuilder() {
  }

  public static AddressBuilder anAddress() {
    return new AddressBuilder();
  }




  public AddressBuilder withPostCode(String postCode) {
    this.postCode = postCode;
    return this;
  }

  public AddressBuilder withAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
    return this;
  }

  public AddressBuilder withAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
    return this;
  }

  public AddressBuilder withAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
    return this;
  }

  public AddressBuilder withCounty(String county) {
    this.county = county;
    return this;
  }

  public AddressBuilder withCountry(String country) {
    this.country = country;
    return this;
  }


  public AddressBuilder fromOperatorFirmDto(RegistrationDto registrationDto){
    this.postCode = registrationDto.getPostcode();
    this.addressLine1 = registrationDto.getAddressLine1();
    this.addressLine2 = registrationDto.getAddressLine2();
    this.addressLine3 = registrationDto.getAddressLine3();
    this.county  = registrationDto.getCounty();
    this.country = registrationDto.getCountry();
    return this;
  }

  public Address build() {
    Address address = new Address();

    address.setCreated(LocalDateTime.now());
    address.setCreatedByUser("System");
    address.setLastModified(LocalDateTime.now());
    address.setLastUpdatedByUser("System");
    address.setPostcode(postCode);
    address.setAddressLine1(addressLine1);
    address.setAddressLine2(addressLine2);
    address.setAddressLine3(addressLine3);
    address.setCounty(county);
    address.setCountry(country);
    return address;
  }
}
