package com.port60.clientadmin.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
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
@Table(name="VEHICLE")
@SequenceGenerator(name = "VEHICLE_SEQ", sequenceName = "VEHICLE_SEQ", allocationSize = 1)
public class Vehicle extends Audit {

	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "VEHICLE_TYPE_ID", nullable = false)
	private VehicleType vehicleType;
	private String registration;
	private LocalDateTime motDate;
	private LocalDateTime authorityTestDate;
	private LocalDateTime annualTaxDate;
	private String insuranceCompanyName;
	private String insurancePolicyNumber;
	private String insuranceExpiryDate;
	private Boolean active;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}
