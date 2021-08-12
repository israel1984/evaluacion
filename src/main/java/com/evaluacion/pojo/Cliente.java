package com.evaluacion.pojo;

import java.util.List;

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
@JsonPropertyOrder({ "nombres", "tipoDocumento","numeroDocumento","fechaNacimiento","lineas"})
public class Cliente {

	private final String nombre;
	private final String tipoDocumento;
	private final String numeroDocumento;
	private final String fechaNacimiento;
	private final List<Linea> lineas;
	
}
