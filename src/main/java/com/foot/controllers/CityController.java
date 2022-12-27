package com.foot.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
import com.foot.services.CityService;

@Path("/cities")
@Stateless
public class CityController {

	@EJB
	private CityService cityService;
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public City addCity(City city) {
//		return cityService.add(city);
//	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public City getCity(@PathParam(value = "id") int id) {
		return cityService.findById(id);
	}

//	@PUT
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public City modifyCity(@PathParam(value = "id") int id, City city) {
//		city.setId(id);
//		return cityService.update(city);
//	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<City> getAllCities() {
		return cityService.findAll();
	}

//	@DELETE
//	@Path("/{id}")
//	public void delete(@PathParam(value = "id") int id) {
//		cityService.delete(id);
//	}

}
