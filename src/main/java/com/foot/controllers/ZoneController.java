package com.foot.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.foot.models.City;
import com.foot.models.Zone;
import com.foot.services.CityService;
import com.foot.services.ZoneService;

@Path("/zones")
@Stateless
public class ZoneController {

	@EJB
	private ZoneService zoneService;
	@EJB
	private CityService cityService;

//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Zone addZone(Zone zone) {
//		return zoneService.add(zone);
//	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Zone getZone(@PathParam(value = "id") int id) {
		return zoneService.findById(id);
	}

//	@PUT
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Zone modifyZone(@PathParam(value = "id") int id, Zone zone) {
//		zone.setId(id);
//		return zoneService.update(zone);
//	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Zone> getAllCities() {
		return zoneService.findAll();
	}

//	@DELETE
//	@Path("/{id}")
//	public void delete(@PathParam(value = "id") int id) {
//		zoneService.delete(id);
//	}

}
