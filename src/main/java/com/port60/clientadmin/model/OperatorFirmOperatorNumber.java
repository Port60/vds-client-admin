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
@Table(name="OPERATOR_FIRM_OPERATOR_NUMBER")
@SequenceGenerator(name = "OPERATOR_FIRM_OPERATOR_NUMBER_SEQ", sequenceName = "OPERATOR_FIRM_OPERATOR_NUMBER_SEQ", allocationSize = 1)
public class OperatorFirmOperatorNumber  extends Audit{
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "OPERATOR_FIRM_ID", nullable = false)
	private OperatorFirm operatorFirm;
	@ManyToOne
	@JoinColumn(name = "OPERATOR_NUMBER_ID", nullable = false)
	private OperatorNumber operatorNumber;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;

}
