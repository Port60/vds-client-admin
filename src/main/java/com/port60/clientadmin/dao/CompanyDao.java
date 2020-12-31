package com.port60.clientadmin.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Company;

public interface CompanyDao extends JpaRepository<Company, Long>{

  List<Company> findCompaniesByCompanyNameEquals(String companyName);

}
