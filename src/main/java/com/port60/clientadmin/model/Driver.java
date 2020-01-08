package com.port60.clientadmin.model;

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
@Table(name="DRIVER")
@SequenceGenerator(name = "DRIVER_SEQ", sequenceName = "DRIVER_SEQ", allocationSize = 1)
public class Driver extends Audit {
	
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
	private Address address;
	private String authorityId;
	private String authorityName;
	@ManyToOne
	@JoinColumn(name = "DRIVER_TYPE_ID", nullable = false)
	private DriverType driverType;
	private Boolean evienceUpToDate;
}
