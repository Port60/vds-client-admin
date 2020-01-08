package com.port60.clientadmin.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Data;

@Data
@MappedSuperclass
public class Audit {
	
	@Version
	  private Integer version;

	  private LocalDateTime created;

	  private String createdByUser;

	  private LocalDateTime lastModified;

	  private String lastUpdatedByUser;


}
