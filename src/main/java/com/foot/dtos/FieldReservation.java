package com.foot.dtos;

import java.util.Date;

import com.foot.models.SoccerField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FieldReservation {

	private int fieldId;
	private Date date;
}
