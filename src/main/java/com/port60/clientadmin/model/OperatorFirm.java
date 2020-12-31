package com.port60.clientadmin.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "OPERATOR_FIRM")
@SequenceGenerator(name = "OPERATOR_FIRM_SEQ", sequenceName = "OPERATOR_FIRM_SEQ", allocationSize = 1)
public class OperatorFirm extends Audit {

	@Id
	@GeneratedValue(generator = "OPERATOR_FIRM_SEQ")
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "ADDRESS_ID", nullable = false, referencedColumnName = "ID")
	private Address address;
	private String operatorLicence;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID", nullable = false)
	private Company company;
	private Boolean evidenceUpToDate;

	@OneToMany(mappedBy = "operatorFirm", cascade = CascadeType.ALL)
	private List<OperatorNumber> operatorNumberList;

}
