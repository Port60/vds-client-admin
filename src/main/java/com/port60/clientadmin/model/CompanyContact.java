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
@Table(name="COMPANY_CONTACT")
@SequenceGenerator(name = "COMPANY_CONTACT_SEQ", sequenceName = "COMPANY_CONTACT_SEQ", allocationSize = 1)
public class CompanyContact  extends Audit{
	
	@Id
	private Long id;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	private Company company;
	@ManyToOne
	@JoinColumn(name = "CONTACT_ID", nullable = false)
	private Contact contact;
	private String position;
	private Boolean primaryCompanyContact;
	private Boolean active;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
}
