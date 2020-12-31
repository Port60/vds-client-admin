package com.port60.clientadmin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Data;

@Data
@MappedSuperclass
public class Audit {
	
	@Version
	  private Integer version;

	@JsonIgnore
	  private LocalDateTime created;
	@JsonIgnore
	  private String createdByUser;
	@JsonIgnore
	  private LocalDateTime lastModified;
	@JsonIgnore
	  private String lastUpdatedByUser;


}
