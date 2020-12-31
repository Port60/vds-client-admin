package com.port60.clientadmin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.port60.clientadmin.request.dto.ZonesWrapper;
import com.port60.clientadmin.service.ZoneService;

@RestController
public class ZoneController {
	
	private ZoneService zoneService;
	
	public ZoneController(ZoneService zoneService){
		this.zoneService = zoneService;
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/zones")
	public String saveZones(@RequestBody ZonesWrapper zonesWrapper){
		
		zoneService.saveClientZone(zonesWrapper.getZones());
		System.out.println(zonesWrapper);
		return "Saved succesfully";
	}

}
