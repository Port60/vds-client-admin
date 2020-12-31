package com.port60.clientadmin.service;

import com.port60.clientadmin.builders.AddressBuilder;
import com.port60.clientadmin.builders.CompanyBuilder;
import com.port60.clientadmin.builders.CompanyContactBuilder;
import com.port60.clientadmin.builders.ContactBuilder;
import com.port60.clientadmin.builders.OperatorFirmBuilder;
import com.port60.clientadmin.builders.OperatorNumberBuilder;
import com.port60.clientadmin.dao.CountryDao;
import com.port60.clientadmin.dto.RegistrationDto;
import com.port60.clientadmin.exception.ExceptionStatus;
import com.port60.clientadmin.exception.VDSRuntimeException;
import com.port60.clientadmin.model.Address;
import com.port60.clientadmin.model.Company;
import com.port60.clientadmin.model.CompanyContact;
import com.port60.clientadmin.model.Contact;
import com.port60.clientadmin.model.Country;
import com.port60.clientadmin.model.OperatorFirm;
import java.time.LocalDateTime;
import java.util.Arrays;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class RegistrationService {

  private CompanyService companyService;
  private AddressService addressService;
  private OperatorFirmService operatorFirmService;
  private ContactService contactService;
  private CompanyContactService companyContactService;
  private CountryDao countryDao;


  @Transactional
  public OperatorFirm registerCompanyAndFirm(RegistrationDto registrationDto){
    Country country = lookupCountry(registrationDto);

    Address address = addressService.saveAddress(AddressBuilder.anAddress().fromOperatorFirmDto(
        registrationDto).build());
    Company company = companyService.saveCompany(CompanyBuilder.aCompany().fromOperatorFirmDto(
        registrationDto)
        .withAddress(address)
        .withStartDate(LocalDateTime.now())
        .withActive(Boolean.TRUE)
        .build());

    Contact contact= contactService.saveContact(ContactBuilder.aContact().fromRegistrationDto(registrationDto).build());

    CompanyContact companyContact = companyContactService.saveCompanyContact(CompanyContactBuilder.aCompanyContact().fromRegistrationDto(registrationDto).withCompany(company)
        .withContact(contact)
        .withCompany(company)
        .withStartDate(LocalDateTime.now())
        .withPrimaryCompanyContact(true)
        .withActive(true)
        .build());

    OperatorFirm operatorFirm = operatorFirmService.saveOperatorFirm(OperatorFirmBuilder.anOperatorFirm()
        .fromOperatorFirmDto(
            registrationDto)
        .withAddress(address)
        .withCompany(company)
        .withOperatorNumberList(Arrays.asList(OperatorNumberBuilder.anOperatorNumber().withCountry(country)
            .withNumber(registrationDto.getOperatorNumber()).build()))
        .withEvidenceUpToDate(Boolean.TRUE).build(),company);


    return operatorFirm;
  }

  private Country lookupCountry(RegistrationDto registrationDto) {

    Country country = countryDao.findCountryByNameEquals(registrationDto.getCountry());
    if(country != null){
      return country;
    } else {
      throw new VDSRuntimeException("Country is not supported", ExceptionStatus.COUNTRY_UNSUPPORTED);
    }
  }
}
