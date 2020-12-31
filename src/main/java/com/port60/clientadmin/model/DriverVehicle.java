package com.port60.clientadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="DRIVER_VEHICLE")
@SequenceGenerator(name = "DRIVER_VEHICLE_SEQ", sequenceName = "DRIVER_VEHICLE_SEQ", allocationSize = 1)
public class DriverVehicle extends Audit {
	
	@Id
	@GeneratedValue(generator ="DRIVER_VEHICLE_SEQ" )
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "DRIVER_ID", nullable = false)
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name = "VEHICLE_ID", nullable = false)
	private Vehicle vehicle;

}
