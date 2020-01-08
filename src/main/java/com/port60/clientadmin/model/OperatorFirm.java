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
@Table(name="OPERATOR_FIRM")
@SequenceGenerator(name = "OPERATOR_FIRM_SEQ", sequenceName = "OPERATOR_FIRM_SEQ", allocationSize = 1)
public class OperatorFirm  extends  Audit{
	
	@Id
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
	private Address address;
	private String operatorLicence;
	private LocalDateTime operatorLicenceExpiryDate;
	@ManyToOne
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	private Company company;
	private Boolean evidenceUpToDate;
	private String operatorNumber;
}
