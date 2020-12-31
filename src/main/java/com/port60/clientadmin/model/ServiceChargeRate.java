package com.port60.clientadmin.model;

import java.math.BigDecimal;
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
@Table(name="SERVICE_CHARGE_RATE")
@SequenceGenerator(name = "SERVICE_CHARGE_RATE_SEQ", sequenceName = "SERVICE_CHARGE_RATE_SEQ", allocationSize = 1)
public class ServiceChargeRate extends Audit {

	@Id
	@GeneratedValue(generator ="SERVICE_CHARGE_RATE_SEQ" )
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;
	
	private BigDecimal rate;
	
	private Integer rateType;
	
	@ManyToOne
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "SERVICE_CHARGE_TYPE_ID", nullable = false)
	private ServiceChargeType serviceChargeType;
	
	private Boolean active;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
}
