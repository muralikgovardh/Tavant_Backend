package com.tavant.samplerestapi.errorresponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	public ErrorResponse(String string, List<String> details2) {
		// TODO Auto-generated constructor stub
	}
	private String message;
	private List<String> details;

}
