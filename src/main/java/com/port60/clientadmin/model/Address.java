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
@Table(name="ADDRESS")
@SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
public class Address  extends Audit{
	

	@Id
	private Long id;
	private String postCode;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String county;
	private String country;

}
