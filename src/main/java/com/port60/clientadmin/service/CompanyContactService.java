package com.port60.clientadmin.service;

import com.port60.clientadmin.dao.CompanyContactDao;
import com.port60.clientadmin.model.CompanyContact;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanyContactService {

  private CompanyContactDao companyContactDao;

  @Transactional
  public CompanyContact saveCompanyContact(CompanyContact companyContact){
    return companyContactDao.save(companyContact);
  }
}
