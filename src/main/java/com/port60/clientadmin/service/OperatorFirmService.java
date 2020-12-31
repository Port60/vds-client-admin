package com.port60.clientadmin.service;

import com.port60.clientadmin.dao.OperatorFirmDao;
import com.port60.clientadmin.dao.OperatorNumberDao;
import com.port60.clientadmin.exception.ExceptionStatus;
import com.port60.clientadmin.exception.VDSRuntimeException;
import com.port60.clientadmin.model.Company;
import com.port60.clientadmin.model.OperatorFirm;
import com.port60.clientadmin.model.OperatorNumber;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class OperatorFirmService {


  private OperatorFirmDao operatorFirmDao;
  private OperatorNumberDao operatorNumberDao;


  @Transactional
  public OperatorFirm saveOperatorFirm(OperatorFirm operatorFirm, Company company){

    if(operatorFirmExists(company,operatorFirm)){
      throw new VDSRuntimeException(String.format("Operator Firm name [%s] already available"),
          ExceptionStatus.OPERATOR_FIRM_EXISTS);
    }
    return operatorFirmDao.save(operatorFirm);
  }

  public OperatorNumber saveOperatorNumber(OperatorNumber operatorNumber){
    return operatorNumberDao.save(operatorNumber);
  }

  private Boolean operatorFirmExists(Company company,OperatorFirm operatorFirm) {
    return operatorFirmDao.findOperatorFirmsByCompanyAndName(company,operatorFirm.getName()).stream()
        .count() > 0;
  }
}
