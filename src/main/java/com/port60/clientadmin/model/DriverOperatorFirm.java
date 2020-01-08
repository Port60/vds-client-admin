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
@Table(name = "DRIVER_OPERATOR_FIRM")
@SequenceGenerator(name = "DRIVER_OPERATOR_FIRM_SEQ", sequenceName = "DRIVER_OPERATOR_FIRM_SEQ", allocationSize = 1)

public class DriverOperatorFirm extends Audit {

	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "DRIVER_ID", nullable = false)
	private Driver driver;
	@ManyToOne
	@JoinColumn(name = "OPERATOR_FIRM_ID", nullable = false)
	private OperatorFirm operatorFirm;
	private Boolean active;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	@ManyToOne
	@JoinColumn(name = "SHIFT_PROFILE_ID", nullable = false)
	private ShiftProfile shiftProfile;
}
