package com.port60.clientadmin.model;

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
@Table(name="COUNTRY")
@SequenceGenerator(name = "COUNTRY_SEQ", sequenceName = "COUNTRY_SEQ", allocationSize = 1)
public class Country extends Audit{
	
	@Id
	@GeneratedValue(generator ="COUNTRY_SEQ" )
	private Long id;
	private String name;
	private String isoCountryCode;
	private String isoCallingCode;
	private String isoCurrencyCode;
	private String isoLanguageCode;
}
