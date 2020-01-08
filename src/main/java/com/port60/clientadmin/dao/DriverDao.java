package com.port60.clientadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Driver;

public interface DriverDao extends JpaRepository<Driver, Long>{

}
