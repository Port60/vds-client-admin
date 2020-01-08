package com.port60.clientadmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.port60.clientadmin.model.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle,Long>{

}
