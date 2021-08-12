package com.evaluacion.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor @Getter
//-- para el swager -- @ApiModel(description = "Objeto que hace referencia a la respuesta del api, devolvera 3 listas, informacion del producto actual, informacion adicional, y ofertas sugeridas")
@Data
@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({ "codigoOferta", "descripcion","fechaInicio","fechaFin"})
public class Oferta {

	private final String codigoOferta;
	private final String descripcion;
	private final String fechaInicio;
	private final String fechaFin;
	
}
