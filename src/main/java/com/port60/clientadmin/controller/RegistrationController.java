package com.port60.clientadmin.controller;

import com.port60.clientadmin.dto.RegistrationDto;
import com.port60.clientadmin.model.OperatorFirm;
import com.port60.clientadmin.service.RegistrationService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RegistrationController {

	private RegistrationService registrationService;

	public RegistrationController(RegistrationService registrationService){
		this.registrationService = registrationService;
	}

	@PostMapping(value = "/register/company", consumes ="application/json", produces = "application/json" )
	public @ResponseBody OperatorFirm saveOperatorFirm( @Valid  @RequestBody RegistrationDto registrationDto){
		return registrationService.registerCompanyAndFirm(registrationDto);
	}
}
