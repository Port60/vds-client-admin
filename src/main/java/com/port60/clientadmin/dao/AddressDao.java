package com.port60.clientadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Address;

public interface AddressDao extends JpaRepository<Address, Long>{

}
