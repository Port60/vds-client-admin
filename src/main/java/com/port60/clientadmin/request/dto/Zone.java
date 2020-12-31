package com.port60.clientadmin.request.dto;


import org.locationtech.jts.geom.Geometry;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.port60.clientadmin.helpers.GeometryDeserializer;


import lombok.Data;

@Data
public class Zone {

	@JsonDeserialize(using=GeometryDeserializer.class)
	private Geometry geometry;
	
	private String id;
	
	private String name;
}
