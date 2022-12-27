package com.foot.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReservationDTO {

	private int id;
	private Date date;
	@Builder.Default
	private Set<FieldReservation> fieldsReservations = new HashSet<>();
}
