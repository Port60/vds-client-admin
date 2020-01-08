package com.port60.clientadmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="VEHICLE_TYPE")
@SequenceGenerator(name = "VEHICLE_TYPE_SEQ", sequenceName = "VEHICLE_TYPE_SEQ", allocationSize = 1)
public class VehicleType extends Audit {
	
	
	@Id
	private Long id;
	
	private String type;
	
	private Integer numberOfSeats;

}
