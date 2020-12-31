package com.port60.clientadmin.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name="SHIFT_PROFILE")
@SequenceGenerator(name = "SHIFT_PROFILE_SEQ", sequenceName = "SHIFT_PROFILE_SEQ", allocationSize = 1)
public class ShiftProfile  extends Audit{

	@Id
	@GeneratedValue(generator ="SHIFT_PROFILE_SEQ" )
	private Long id;
	private String shiftName;
	private LocalTime startTime;
	private LocalTime endTime;
	private Integer days;
}
