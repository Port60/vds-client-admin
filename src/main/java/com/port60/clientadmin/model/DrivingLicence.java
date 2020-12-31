package com.port60.clientadmin.model;

import java.time.LocalDateTime;

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
@Table(name="DRIVING_LICENCE")
@SequenceGenerator(name = "DRIVING_LICENCE_SEQ", sequenceName = "DRIVING_LICENCE_SEQ", allocationSize = 1)
public class DrivingLicence extends Audit {
	
	@Id
	@GeneratedValue(generator ="DRIVING_LICENCE_SEQ" )
	private Long id;
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;
	private String licenceNumber;
	private LocalDateTime licenceExpiryDate;
	@ManyToOne
	@JoinColumn(name = "DRIVING_LICENCE_TYPE_ID", nullable = false)
	private DrivingLicenceType drivingLicenceType;
}
