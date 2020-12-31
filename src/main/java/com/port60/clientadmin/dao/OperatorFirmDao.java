package com.port60.clientadmin.dao;

import com.port60.clientadmin.model.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.OperatorFirm;

public interface OperatorFirmDao extends JpaRepository<OperatorFirm, Long>{

  List<OperatorFirm> findOperatorFirmsByCompanyAndName(Company company,String name);

}
