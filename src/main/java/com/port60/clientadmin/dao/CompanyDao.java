package com.port60.clientadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Company;

public interface CompanyDao extends JpaRepository<Company, Long>{

}
