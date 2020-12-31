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
@Table(name="SERVICE_CHARGE_RUN")
@SequenceGenerator(name = "SERVICE_CHARGE_RUN_SEQ", sequenceName = "SERVICE_CHARGE_RUN_SEQ", allocationSize = 1)
public class ServiceChargeRun extends Audit {

	@Id
	@GeneratedValue(generator ="SERVICE_CHARGE_RUN_SEQ" )
	private Long id;
	@ManyToOne
	@JoinColumn(name = "SERVICE_CHARGE_RATE_ID", nullable = false)
	private ServiceChargeRate serviceChargeRate;
	private LocalDateTime runDate;
}
