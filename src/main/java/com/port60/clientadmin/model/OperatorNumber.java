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
@Table(name="OPERATOR_NUMBER")
@SequenceGenerator(name = "OPERATOR_NUMBER_SEQ", sequenceName = "OPERATOR_NUMBER_SEQ", allocationSize = 1)
public class OperatorNumber extends Audit {
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;
	
	private String number;
	

}
