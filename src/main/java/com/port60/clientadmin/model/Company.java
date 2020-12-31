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
@Table(name="COMPANY")
@SequenceGenerator(name = "COMPANY_SEQ", sequenceName = "COMPANY_SEQ", allocationSize = 1)
public class Company extends Audit {

	@Id
	@GeneratedValue(generator ="COMPANY_SEQ" )
	private Long id;
	private String companyName;
	private String companyRegNumber;
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", nullable = false)
	private Address address;
	private Boolean active;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}
