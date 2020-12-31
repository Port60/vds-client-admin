package com.port60.clientadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name="DRIVING_LICENCE_TYPE")
@SequenceGenerator(name = "DRIVING_LICENCE_TYPE_SEQ", sequenceName = "DRIVING_LICENCE_TYPE_SEQ", allocationSize = 1)
public class DrivingLicenceType extends Audit {
	
	@Id
	@GeneratedValue(generator ="DRIVING_LICENCE_TYPE_SEQ" )
	private Long id;
	private String licenceType;
}
