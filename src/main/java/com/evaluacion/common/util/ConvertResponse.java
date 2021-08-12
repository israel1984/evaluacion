package com.evaluacion.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeList;

import com.evaluacion.model.ClienteT;
import com.evaluacion.model.LineaT;
import com.evaluacion.model.OfertaT;
import com.evaluacion.pojo.*;
import com.evaluacion.pojo.RespData;

public class ConvertResponse {

	public ConvertResponse() {
		
	}
	
	public static RespData convertToResponse(List<ClienteT> listClientes, List<LineaT> listLineas, List<OfertaT> listOfertas) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		for (ClienteT cli : listClientes) {
			
			listaCliente.add(new Cliente(cli.getNombres(),cli.getTipoDoc(),cli.getNumeroDoc(),sdf.format(cli.getFechaNacimiento()), new ArrayList<Linea>()));
			
		}
		
		for (LineaT line : listLineas) {
			
			for (Cliente cliente : listaCliente) {
				
				if(cliente.getNumeroDocumento().equals(line.getNumeroDocumento())) {
					
					List<Oferta> listOferrs = new ArrayList<Oferta>();
					
					for (OfertaT offer : listOfertas) {
						if(offer.getCodigoOferta().equals(line.getCodigoOferta())) {
							listOferrs.add(new Oferta(offer.getCodigoOferta(),offer.getDescripcion(),sdf.format(offer.getFecIni()),sdf.format(offer.getFecFin())));
						}
					}
					
					cliente.getLineas().add(new Linea(line.getTelefono(),line.getEstado(),line.getTipo(),line.getPlan(), listOferrs));
					
					
					
				}
				
			}
			
		}
		
		RespData data = new RespData(listaCliente);
		
		
		
		return data;
	}
	
}
