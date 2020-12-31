package com.port60.clientadmin.model;

import javax.persistence.Column;
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
@Table(name="CONTACT")
@SequenceGenerator(name = "CONTACT_SEQ", sequenceName = "CONTACT_SEQ", allocationSize = 1)
public class Contact extends Audit {
	
	@Id
	@GeneratedValue(generator ="CONTACT_SEQ" )
	private Long id;
	private String title;
	private String firstName;
	private String lastName;
	private String telephoneNumber;
	private String email;

	

}
