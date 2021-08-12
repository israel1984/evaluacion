package com.evaluacion.pojo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"fechaInicio","fechaFin"})
public class ReqDataRangoFechas {

	@Valid
    @NotNull(message = "Ingrese la fecha inicio")
	private String fechaInicio;
	
	@Valid
    @NotNull(message = "Ingrese la fecha fin")
	private String fechaFin;
	
}
