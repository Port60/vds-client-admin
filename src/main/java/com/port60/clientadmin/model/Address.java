package com.port60.clientadmin.model;

import javax.persistence.Column;
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
@Table(name="ADDRESS")
@SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
public class Address  extends Audit{
	

	@Id
	@GeneratedValue(generator ="ADDRESS_SEQ" )
	private Long id;
	private String postcode;
	@Column(name = "ADDRESS_LINE_1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE_2")
	private String addressLine2;
	@Column(name = "ADDRESS_LINE_3")
	private String addressLine3;
	private String county;
	private String country;

}
