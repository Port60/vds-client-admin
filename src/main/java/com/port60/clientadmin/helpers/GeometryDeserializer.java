package com.port60.clientadmin.helpers;

import java.io.IOException;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.wololo.jts2geojson.GeoJSONReader;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


public class GeometryDeserializer extends JsonDeserializer<Geometry> {

	@Override
	public Geometry deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		GeoJSONReader reader  = new GeoJSONReader();
	
		GeometryFactory factory =  new GeometryFactory(	new PrecisionModel(PrecisionModel.FLOATING),4326);
		Geometry geometry = reader.read(p.getText(),factory);

		return geometry;
	}
}
