package com.port60.clientadmin.service;

import com.port60.clientadmin.dao.CompanyDao;
import com.port60.clientadmin.exception.VDSRuntimeException;
import com.port60.clientadmin.exception.ExceptionStatus;
import com.port60.clientadmin.model.Company;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class CompanyService {

  private CompanyDao companyDao;

  @Transactional
  public Company saveCompany(Company company) {

    if(companyExists(company)){
      throw new VDSRuntimeException(String.format("Company name [%s] not available",company.getCompanyName()),
          ExceptionStatus.COMPANY_EXISTS);
    }
    return companyDao.save(company);
  }

  public Boolean companyExists(Company company) {

    return companyDao.findCompaniesByCompanyNameEquals(company.getCompanyName()).stream()
        .count() > 0;
  }
}
