package com.port60.clientadmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="SERVICE_CHARGE_TYPE")
@SequenceGenerator(name = "SERVICE_CHARGE_TYPE_SEQ", sequenceName = "SERVICE_CHARGE_TYPE_SEQ", allocationSize = 1)
public class ServiceChargeType extends Audit {

	@Id
	private Long id;
	
	private Long type;
	
	private Integer frequency;
	
	private Integer billingDay;
	
	
}
