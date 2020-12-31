package com.port60.clientadmin.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name="OPERATOR_NUMBER")
@SequenceGenerator(name = "OPERATOR_NUMBER_SEQ", sequenceName = "OPERATOR_NUMBER_SEQ", allocationSize = 1)
public class OperatorNumber extends Audit {
	
	@Id
	@GeneratedValue(generator ="OPERATOR_NUMBER_SEQ" )
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;
	
	private String number;

	@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,
			property="id")
	@JsonIdentityReference(alwaysAsId=true)
	@JsonProperty("operatorFirmId")
	@ManyToOne
	@JoinColumn(name = "OPERATOR_FIRM_ID", nullable = false, referencedColumnName = "ID")
	private OperatorFirm operatorFirm;

}
