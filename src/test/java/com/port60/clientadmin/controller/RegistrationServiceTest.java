package com.port60.clientadmin.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.port60.clientadmin.dto.RegistrationDto;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationServiceTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void registerCompany() throws Exception {

		RegistrationDto registrationDto = new RegistrationDto();
		registrationDto.setName("Test Operator Firm");
		registrationDto.setAddressLine1("88 Oakly Road");
		registrationDto.setAddressLine2("Redditch");
//		registrationDto.setAddressLine3("");
		registrationDto.setCounty("Worcestershire");
		registrationDto.setCountry("United Kingdom");
		registrationDto.setPostcode("B97 4EE");
		registrationDto.setOperatorLicence("lic-123456");
		registrationDto.setOperatorNumber("0987654321");
		registrationDto.setCompanyRegNumber("098765432wee");

		registrationDto.setContactTitle("Mr");
		registrationDto.setContactFirstName("Testfirstname");
		registrationDto.setContactLastName("testlastname");
		registrationDto.setContactEmail("testemail");
		registrationDto.setContactPosition("testposition");
		registrationDto.setContactPhoneNumber("0987654321");

		this.mockMvc.perform(post("/register/company").content(objectMapper.writeValueAsString(
				registrationDto)).contentType(
				MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
				.andDo(print());
	}

//	@Test
//	void loadOperatorFirm() throws Exception {
//		this.mockMvc.perform(get("/register/company")).andDo(print()).andExpect(status().isOk());
////				.andExpect(content().string(containsString("Hello, World")));
//	}

}
