package com.port60.clientadmin.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.port60.clientadmin.dao.ClientZoneDao;
import com.port60.clientadmin.model.ClientZone;
import com.port60.clientadmin.request.dto.Zone;

@Service
public class ZoneService {

	private ClientZoneDao clientZoneDao;
	
	public ZoneService(ClientZoneDao clientZoneDao){
		this.clientZoneDao = clientZoneDao;
	}
	
	
	@Transactional
	public List<ClientZone> saveClientZone(List<Zone> zones){
		List<ClientZone> clientZones = zones.stream().map(z -> new ClientZone(z.getName(),z.getId(),z.getGeometry()))
		.collect(Collectors.toList());
		
		clientZones.stream().forEach((zone) -> clientZoneDao.save(zone));
		
		
		return clientZones;
	}
}
