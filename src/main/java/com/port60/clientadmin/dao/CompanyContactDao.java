package com.port60.clientadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.CompanyContact;

public interface CompanyContactDao extends JpaRepository<CompanyContact, Long>{

}
