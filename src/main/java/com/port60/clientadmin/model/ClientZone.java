package com.port60.clientadmin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.locationtech.jts.geom.Geometry;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="CLIENT_ZONE")
@SequenceGenerator(name = "CLIENT_ZONE_SEQ", sequenceName = "CLIENT_ZONE_SEQ", allocationSize = 1)
public class ClientZone extends Audit {
	

	@Id
	@GeneratedValue(generator="CLIENT_ZONE_SEQ")
	private Long id;
	private String name;
	private String zoneMappingId;
	@Column(name="ZONE_GEOMETRY", columnDefinition="GEOGRAPHY(POLYGON)" )
	private Geometry zonePolygon;
	
	public ClientZone(){}
	
	public ClientZone(String name, String zoneMappingId, Geometry zonePolygon){
		this.name = name;
		this.zoneMappingId = zoneMappingId;
		this.zonePolygon = zonePolygon;
			
	}
	
	public ClientZone(Long id,String name, String zoneMappingId, Geometry zonePolygon){
		this.id = id;
		this.name = name;
		this.zoneMappingId = zoneMappingId;
		this.zonePolygon = zonePolygon;
			
	}
}

