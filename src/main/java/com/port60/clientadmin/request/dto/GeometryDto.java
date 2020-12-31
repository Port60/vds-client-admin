package com.port60.clientadmin.request.dto;

import java.util.List;

import org.locationtech.jts.geom.CoordinateArrays;

import lombok.Data;

@Data
public class GeometryDto {
	
	private List<CoordinateArrays> coordinates;
	private String type;

}
