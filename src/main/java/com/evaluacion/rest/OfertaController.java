package com.evaluacion.rest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.model.ClienteT;
import com.evaluacion.pojo.Cliente;
import com.evaluacion.pojo.ReqDataNroTipoDoc;
import com.evaluacion.pojo.ReqDataRangoFechas;
import com.evaluacion.pojo.RespData;
import com.evaluacion.repository.ClienteRepository;
import com.evaluacion.service.IOfferService;



@RestController
public class OfertaController {

	List<Cliente> listaClientes = new ArrayList<Cliente>();	
	
	@Autowired
    private IOfferService offerService;
	
	@GetMapping("/getDataNroTipoDocumento")
	public RespData getDataNroTipoDocumento(@Valid @RequestBody ReqDataNroTipoDoc request) {
		
		Cliente cliente = new Cliente("", "", "", "", null);
		
		System.out.println("este es el nro de documento: "+request.getNro_documento());
		
		RespData data = offerService.obtenerLIstaXNumeroTipoDocumento(request);
		
		
		
		listaClientes.add(cliente);
		
		return data;
		
	}
	
	@GetMapping("/getDataRangoFechas")
	public RespData getData(@Valid @RequestBody ReqDataRangoFechas request) {
		
		RespData data = new RespData(listaClientes);
		
		try {	
		
		data = offerService.obtenerLIstaXRangoFechas(request);
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//listaClientes.add(cliente);
		
		return data;
		
	}
	
}
