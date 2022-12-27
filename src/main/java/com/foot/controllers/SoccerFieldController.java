package com.foot.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.foot.models.SoccerField;
import com.foot.services.SoccerFieldService;
import com.foot.services.ZoneService;

@Path("/fields")
@Stateless
public class SoccerFieldController {

	@EJB
	private ZoneService zoneService;
	@EJB
	private SoccerFieldService soccerFieldService;


	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SoccerField getZone(@PathParam(value = "id") int id) {
		return soccerFieldService.findById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SoccerField> getFields() {
		return soccerFieldService.findAll();
	}

	@GET
	@Path("/filter")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SoccerField> getFields(@QueryParam("name") String name, @QueryParam("adr") String address) {
		List<SoccerField> res = soccerFieldService.findAll(); 
		if (name != null)
			res = res.stream().filter(sf -> sf.getName().contains(name)).collect(Collectors.toList());
		if (address != null)
			res = res.stream().filter(sf -> sf.getAddress().contains(address)).collect(Collectors.toList());
			
		return res;
	}

}
