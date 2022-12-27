package com.foot.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.foot.dtos.ReservationDTO;
import com.foot.models.Reservation;
import com.foot.models.ReservationSoccerField;
import com.foot.services.ReservationService;
import com.foot.services.SoccerFieldService;

@Path("/reservations")
@Stateless
public class ReservationController {

	@EJB
	private ReservationService resService;
	@EJB
	private SoccerFieldService fieldService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reservation addRes(ReservationDTO res) {
		Reservation resToAdd = Reservation.builder().date(res.getDate()).build();
		List<ReservationSoccerField> fieldsReservations = res.getFieldsReservations().stream().map(f -> {
			return ReservationSoccerField.builder().soccerField(fieldService.findById(f.getFieldId()))
					.date(f.getDate()).build();
		}).collect(Collectors.toList());
		return resService.add(resToAdd, fieldsReservations);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation getReservation(@PathParam(value = "id") int id) {
		return resService.findById(id);
	}

	@GET
	@Path("/{id}/fields")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReservationSoccerField> getFieldsReservations(@PathParam(value = "id") int id) {
		return resService.findFieldsReservationById(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getAllRes() {
//		List<ReservationDTO> result = resService.findAll().stream()
//				.map(r -> ReservationDTO.builder().id(r.getId()).date(r.getDate()).build()).toList();
//		result.forEach(r -> resService.findFieldsReservationById(r.getId()).forEach(f -> r.getFieldsReservations()
//				.add(FieldReservation.builder().date(f.getDate()).field(f.getSoccerField()).build())));
//		return result;
		return resService.findAll();
	}

}
