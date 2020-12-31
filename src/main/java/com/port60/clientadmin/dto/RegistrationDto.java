package com.port60.clientadmin.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;


@Data
public class RegistrationDto {

  @NotEmpty
  @Size(max = 100)
  private String name;
  @NotEmpty
  @Size(max = 12)
  private String postcode;
  @NotEmpty
  @Size(max = 100)
  private String addressLine1;
  @NotEmpty
  @Size(max = 100)
  private String addressLine2;
  @Size(max = 100)
  private String addressLine3;
  @NotEmpty
  @Size(max = 50)
  private String county;
  @NotEmpty
  @Size(max = 50)
  private String country;
  @NotEmpty
  @Size(max = 50)
  private String operatorLicence;
 //Need to thing about thisim not sure we should be asking for this unless
  @NotEmpty
  @Size(max = 15)
  private String operatorNumber;
  @Size(max = 30)
  private String companyRegNumber;
  @NotEmpty
  @Size(max = 50)
  private String contactTitle;
  @Size(max = 100)
  @NotEmpty
  private String contactFirstName;
  @Size(max = 100)
  @NotEmpty
  private String contactLastName;
  @Size(max = 100)
  @NotEmpty
  private String contactEmail;
  @Size(max = 20)
  @NotEmpty
  private String contactPhoneNumber;
  @Size(max = 100)
  @NotEmpty
  private String contactPosition;

}
