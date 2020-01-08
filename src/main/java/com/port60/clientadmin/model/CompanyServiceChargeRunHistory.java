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
@Table(name="COMPANY_SERVICE_CHARGE_RUN_HISTORY")
@SequenceGenerator(name = "COMPANY_SERVICE_CHARGE_RUN_HISTORY_SEQ", sequenceName = "COMPANY_SERVICE_CHARGE_RUN_HISTORY_SEQ", allocationSize = 1)
public class CompanyServiceChargeRunHistory extends Audit {
	
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "SERVICE_CHARGE_RUN_ID", nullable = false)
	private ServiceChargeRun serviceChargeRun;
	@ManyToOne
	@JoinColumn(name = "DRIVER_ID", nullable = false)
	private Driver driver;
	
	private Boolean paid;
}
