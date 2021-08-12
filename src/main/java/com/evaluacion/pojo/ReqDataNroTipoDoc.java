package com.evaluacion.pojo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"nro_documento","tipo_documento"})
public class ReqDataNroTipoDoc {

	@Valid
    @NotNull(message = "Ingrese el número de documento")
	private String nro_documento;
	
	@Valid
    @NotNull(message = "Ingrese el tipo de documento")
	private String tipo_documento;
	
}
